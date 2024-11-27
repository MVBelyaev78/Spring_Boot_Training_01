package com.example.springboottraining01;

import java.util.ArrayList;
import java.util.Objects;

public class CoffeeList {
    private final ArrayList<Coffee> coffees;

    public CoffeeList(ArrayList<Coffee> coffees) {
        this.coffees = coffees;
    }

    public CoffeeList() {
        this.coffees = Test.initCoffeeList();
    }

    public Iterable<Coffee> getCoffees() {
        return coffees;
    }

    public Iterable<Coffee> getCoffees(String id) {
        return coffees
                .stream()
                .filter(e -> Objects.equals(e.getId(), id))
                .toList();
    }
    public void addCoffee(Coffee coffee) {
        coffees.add(coffee);
    }
}
