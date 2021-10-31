package com.alfimenkov.task2.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements Component {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sentence.class);
    private ArrayList<Component> components = new ArrayList<>();

    public Sentence() {

    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<Component> components) {
        this.components = components;
    }

    public ArrayList<Word> getWords(){

        ArrayList<Word> words = new ArrayList<Word>();

        for (Component component : components) {
            if(component instanceof Word){
                words.add((Word) component);
            }
        }

        return words;
    }

    @Override
    public String getValue() {

        String value = "";
        for (Component component : components) {
            if(component instanceof Mark) value += component.getValue();
            else value +=  " " + component.getValue() ;
        }
        return value;
    }

    @Override
    public int length() {
        return components.stream().mapToInt(Component::length).sum();
    }

    public void addComponent(Component component) {

        this.components.add(component);
    }

    public void addComponents(List<Component> components) {

        this.components.addAll(components);
    }

    public void deleteWordByLength(Word word, int length) {

        if (word.length() == length && word.isStartsWithConsonant() && !word.isNumeric()) {
            LOGGER.debug("Word {} was successfully deleted.",word.getValue());
            this.components.remove(word);
        }
    }


    public void deleteWordsByLength(int length) {

        for (Word word : getWords()) {
            deleteWordByLength(word,length);
        }
    }

}
