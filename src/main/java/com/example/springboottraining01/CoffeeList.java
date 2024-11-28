package com.example.springboottraining01;

import java.util.*;

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

    public boolean modifyCoffee(String id, Coffee coffee) {
        boolean resultModify;
        List<Coffee> resultList = coffees
                .stream()
                .filter(e -> e.getId().equals(id))
                .toList();
        if (resultList.isEmpty()) {
            coffees.add(coffee);
            resultModify = false;
        } else {
            resultList.forEach(e -> e = coffee);
            resultModify = true;
        }
        return resultModify;
    }

    public void deleteCoffee(String id) {
        coffees.removeIf(e -> e.getId().equals(id));
    }
}
