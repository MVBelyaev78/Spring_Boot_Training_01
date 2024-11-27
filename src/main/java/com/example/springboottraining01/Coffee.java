package com.example.springboottraining01;

import java.util.UUID;

public class Coffee {
    private final String id = UUID.randomUUID().toString();
    private String name;

    public Coffee(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
