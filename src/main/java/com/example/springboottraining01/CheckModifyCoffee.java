package com.example.springboottraining01;

public record CheckModifyCoffee(Coffee coffee, Integer typeModify) {
    public static final Integer getOK = 0;
    public static final Integer getSet = 1;
    //
    public static final Integer getNonExisis = -1;
}
