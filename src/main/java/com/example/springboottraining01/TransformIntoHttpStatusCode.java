package com.example.springboottraining01;

public class TransformIntoHttpStatusCode {
    public static Integer getTransValue(Integer typeModify) {
        return switch (typeModify) {
            case 0 -> 200; // OK
            case 1 -> 201; // CREATED
            default -> -1;
        };
    }
}
