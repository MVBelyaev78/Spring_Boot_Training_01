package com.example.springboottraining01.service;

import org.springframework.http.HttpStatus;

public class TransformIntoHttpStatus {
    public static HttpStatus getHttpStatus(Integer typeModify) {
        return switch (typeModify) {
            case 0 -> HttpStatus.OK;
            case 1 -> HttpStatus.CREATED;
            default -> HttpStatus.valueOf(-1);
        };
    }
}
