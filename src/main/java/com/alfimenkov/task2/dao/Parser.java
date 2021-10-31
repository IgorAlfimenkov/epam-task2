package com.alfimenkov.task2.dao;

import com.alfimenkov.task2.entity.Component;
import com.alfimenkov.task2.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Parser  {

    private static final Logger LOGGER = LoggerFactory.getLogger(Parser.class);

    public static Text parse(String value) {

        LOGGER.debug("Starting parse of string:\n {}",value);
        String textValue = value.replace("’","");
        Text text = new Text();
        text.setComponents(splitIntoParagraphs(textValue));
        LOGGER.debug("Get text with length : {} symbols",  text.length());
        return text;
    }

    public static ArrayList<Component> splitIntoParagraphs(String value) {

        ArrayList<Component> paragraphs = new ArrayList<>();
        String[] paragraphsValue = value.split("(?m)(?=\t)");
        for (String p : paragraphsValue) {

            Paragraph paragraph = new Paragraph();
            Pattern pattern = Pattern.compile("(?<!\\w\\.\\w.)(?<![A-Z][a-z]\\.)(?<=\\.|\\?|\\!)\\s");
            String[] sentencesValue = pattern.split(p);
            paragraph.setComponents(splitIntoSentences(sentencesValue));
            paragraphs.add(paragraph);
        }

        return paragraphs;
    }

    public static ArrayList<Component> splitIntoSentences(String[] sentencesValue) {

        ArrayList<Component> sentences = new ArrayList<>();
        for (String s : sentencesValue) {

            sentences.add(splitIntoWords(s.replaceAll("\t","").split(" "), new Sentence()));
        }

        return sentences;
    }

    public static Component splitIntoWords(String[] wordsValue, Sentence sentence) {

        Pattern markPattern = Pattern.compile("[!.,?;():]");
        for (int i = 0; i < wordsValue.length; i++) {

            Word word = new Word();
            Mark mark = null;
            char[] values = wordsValue[i].toCharArray();
            for (char value : values) {

                if(markPattern.matcher(String.valueOf(value)).find()) {
                    mark = new Mark(value);
                }
                else word.add(new Letter(value));
            }
            sentence.addComponent(word);
            if(mark != null) sentence.addComponent(mark);
        }

        return sentence;
    }

}
