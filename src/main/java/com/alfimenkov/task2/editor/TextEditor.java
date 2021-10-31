package com.alfimenkov.task2.editor;

import com.alfimenkov.task2.dao.Parser;
import com.alfimenkov.task2.dao.Reader;
import com.alfimenkov.task2.entity.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextEditor implements ITextEditor {

    private Text text;
    private static final Logger LOGGER = LoggerFactory.getLogger(TextEditor.class);

    public TextEditor() throws Exception {
        this.text = Parser.parse(Reader.readTextFile("src/main/resources/input.txt"));
    }

    public TextEditor(String filename) throws Exception {

        this.text = Parser.parse(Reader.readTextFile("src/main/resources/" + filename));
    }

    public String getText() {

        LOGGER.debug("Method getText started.");
        String textValue = text.getValue();
        LOGGER.debug("getText returns text :\n{}", textValue);
        return textValue;
    }

    public void deleteWordsByLength(int length) {
        LOGGER.debug("Method deleteWordsByLength started.");
        text.deleteWordsByLength(length);
    }
}
