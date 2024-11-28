package com.example.springboottraining01;

public class CheckModifyCoffee {
    private final Coffee coffee;
    private final Boolean typeModify;

    public CheckModifyCoffee(Coffee coffee, Boolean typeModify) {
        this.coffee = coffee;
        this.typeModify = typeModify;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public Boolean getTypeModify() {
        return typeModify;
    }
}
