package com.alfimenkov.task2.entity;

import java.util.ArrayList;

public class Paragraph implements Component {

    private ArrayList<Component> components = new ArrayList<>();

    public Paragraph() {
    }

    public Paragraph(ArrayList<Component> components) {
        this.components = components;
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public void addComponent(Component component) {
        this.components.add(component);
    }

    public void deleteComponent(Component component) {
        components.remove(component);
    }

    public void deleteWordsByLength(int length) {

        for (Component component : components) {
            ((Sentence)component).deleteWordsByLength(length);
        }
    }


    public void setComponents(ArrayList<Component> components) {
        this.components = components;
    }

    public ArrayList<Sentence> getSentences(){

        ArrayList<Sentence> sentences = new ArrayList<>();

        for (Component component : components) {
            if(component instanceof Sentence ){
                sentences.add((Sentence) component);
            }
        }

        return sentences;
    }

    @Override
    public String getValue() {
        String paragraph = "";

        for (Component component : this.components) {

            paragraph += component.getValue().trim() + " " ;
        }
        return paragraph;
    }

    @Override
   public int length() {

        return components.stream().mapToInt(Component::length).sum();
   }
}
