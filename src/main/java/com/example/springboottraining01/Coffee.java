package com.example.springboottraining01;

import java.util.UUID;

public class Coffee {
    private final UUID id = UUID.randomUUID();
    private String name;

    public Coffee(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
