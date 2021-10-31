package com.alfimenkov.task2.entity;

import java.util.ArrayList;

public class Letter implements Component {
    private char value;

    public Letter(char value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return String.valueOf(value);
    }

    @Override
    public int length() {
        return 1;
    }

}
