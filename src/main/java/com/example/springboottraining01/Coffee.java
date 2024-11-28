package com.example.springboottraining01;

import exception.NameIsAbsentException;

import java.util.UUID;

public class Coffee {
    private final String id = UUID.randomUUID().toString();
    private String name;

    public Coffee(String name) {
        this.name = name;
        checkName();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        checkName();
    }

    private void checkName() {
        if (name.isEmpty()) {
            throw new NameIsAbsentException("Coffee's name must be present");
        }
    }
}
