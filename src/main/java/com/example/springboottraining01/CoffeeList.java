package com.example.springboottraining01;

import exception.IdIsAlreadyPresentException;

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

    public CheckModifyCoffee addCoffee(Coffee coffee) {
        return mergeCoffee(coffee, true);
    }

    public CheckModifyCoffee modifyCoffee(Coffee coffee) {
        return mergeCoffee(coffee, false);
    }

    public void deleteCoffee(String id) {
        coffees.removeIf(e -> e.getId().equals(id));
    }
/*
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
*/
    private CheckModifyCoffee mergeCoffee(Coffee coffee, String id, Boolean addOnly) {
        CheckModifyCoffee result;
        Optional<Coffee> resultOptional = coffees
                .stream()
                .filter(e -> e.getId().equals(coffee.getId()))
                .findFirst();
        if (resultOptional.isEmpty()) {
            coffees.add(coffee);
            result = new CheckModifyCoffee(coffee, false);
        } else if (!addOnly) {
            coffees.stream()
                    .filter(e -> e.getId().equals(id)
                    .forEach(e -> {
                        e.setName(coffee.getName());
                    });
            result = new CheckModifyCoffee(resultOptional.get(), true);
        } else {
            throw new IdIsAlreadyPresentException("The coffee with this id is already present");
        }
        return result;
    }

    private CheckModifyCoffee mergeCoffee(Coffee coffee, Boolean addOnly) {
        return CheckModifyCoffee mergeCoffee(coffee, "", addOnly);
    }
}
