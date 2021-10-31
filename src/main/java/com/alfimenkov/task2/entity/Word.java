package com.alfimenkov.task2.entity;

import java.util.ArrayList;

public class Word implements Component {

    private ArrayList<Component> components = new ArrayList<>();

    public Word() {

    }

    public Word(ArrayList<Component> components) {
        this.components = components;
    }

    @Override
    public String getValue() {
        String word = "";
        for (Component component : components) {
            if(component != null) word += component.getValue();
        }

        return word;
    }

    public void add(Component component){

        this.components.add(component);
    }



    public ArrayList<Component> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<Component> components) {
        this.components = components;
    }

    public int length() {
        return  getComponents().stream().mapToInt(Component::length).sum();
    }

    public boolean isStartsWithConsonant() {
        return getValue().matches("^[^aeiou]+[a-z]*$");
    }

    public boolean isNumeric() {

        return getValue().matches("\\d+");
    }

}
