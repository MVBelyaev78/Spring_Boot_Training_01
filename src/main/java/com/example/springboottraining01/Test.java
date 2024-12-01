package com.example.springboottraining01;

import com.example.springboottraining01.service.Coffee;

import java.util.ArrayList;
import java.util.List;

class Test {
    static ArrayList<Coffee> initCoffeeList() {
        return new ArrayList<>(List.of(
                new Coffee("Café Cereza"),
                new Coffee("Café Ganador"),
                new Coffee("Café Lareño"),
                new Coffee("Café Três Pontas")
        ));
    }
}
