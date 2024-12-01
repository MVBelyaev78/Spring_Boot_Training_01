package com.example.springboottraining01.service;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static ArrayList<Coffee> initCoffeeList() {
        return new ArrayList<>(List.of(
                new Coffee("Café Cereza"),
                new Coffee("Café Ganador"),
                new Coffee("Café Lareño"),
                new Coffee("Café Três Pontas")
        ));
    }
}
