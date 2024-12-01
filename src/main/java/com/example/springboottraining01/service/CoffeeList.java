package com.example.springboottraining01.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CoffeeList {
    private final ArrayList<Coffee> coffees = Test.initCoffeeList();

    public Iterable<Coffee> getCoffees() {
        return coffees;
    }

    public Optional<Coffee> getCoffeeById(String id) {
        return coffees.stream().filter(e -> Objects.equals(e.getId(), id)).findFirst();
    }

    public CheckModifyCoffee addCoffee(Coffee coffee, Integer typeModify) {
        coffees.add(coffee);
        return new CheckModifyCoffee(coffee, typeModify);
    }

    public CheckModifyCoffee addCoffee(Coffee coffee) {
        return addCoffee(coffee, CheckModifyCoffee.getOK);
    }

    public CheckModifyCoffee setCoffee(String id, Coffee coffee) {
        CheckModifyCoffee coffeeResult;
        if (getCoffeeById(id).isEmpty()) {
            coffeeResult = addCoffee(coffee, CheckModifyCoffee.getSet);
        } else {
            coffees.set(coffees.indexOf(getCoffeeById(id).get()), coffee);
            coffeeResult = new CheckModifyCoffee(coffee, CheckModifyCoffee.getOK);
        }
        return coffeeResult;
    }

    public void deleteCoffee(String id) {
        coffees.removeIf(e -> e.getId().equals(id));
    }
}
