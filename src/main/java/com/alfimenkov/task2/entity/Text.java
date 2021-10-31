package com.alfimenkov.task2.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class Text implements Component {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sentence.class);
    private ArrayList<Component> components = new ArrayList<>();

    public Text() {

    }

    public Text(ArrayList<Component> components) {
        this.components = components;
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public void deleteWordsByLength(int length) {

        for (Component component : components) {

            ((Paragraph)component).deleteWordsByLength(length);
        }
    }


    public void setComponents(ArrayList<Component> components) {
        this.components = components;
    }

    @Override
    public String getValue() {
        LOGGER.debug("Method getValue started.");
        String text = "";
        for (Component component : this.components) {

            text += "\t" + component.getValue() + "\n";
        }
        LOGGER.debug("Method returns string with length : {}", text.length());
        return text;
    }

    @Override
    public int length() {

     return components.stream().mapToInt(Component::length).sum();
    }
}
