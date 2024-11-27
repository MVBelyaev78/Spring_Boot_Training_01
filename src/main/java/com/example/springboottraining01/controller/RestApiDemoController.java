package com.example.springboottraining01.controller;

import com.example.springboottraining01.Coffee;
import com.example.springboottraining01.CoffeeList;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class RestApiDemoController {
    private final CoffeeList coffeeList = new CoffeeList();

    private RestApiDemoController() {
    }

    @GetMapping("/coffees")
    Iterable<Coffee> getCoffees() {
        return coffeeList.getCoffees();
    }

    @GetMapping("/coffees/{id}")
    Iterable<Coffee> getCoffeeById(@PathVariable String id) {
        return coffeeList.getCoffees(id);
    }

    @PostMapping("/coffees")
    Coffee postCoffee(@RequestBody Coffee coffee) {
        coffeeList.addCoffee(coffee);
        return coffee;
    }

    @PutMapping("/coffees/{id}")
    Coffee putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        Coffee result = new Coffee();
        /*int coffeeIndex = -1;
        for (Coffee c : coffees) {
            if (c.getId().equals(id)) {
                coffeeIndex = coffees.indexOf(c);
                coffees.set(coffeeIndex, coffee);
            }
        }
        return (coffeeIndex == -1) ? postCoffee(coffee) : coffee;*/
        return result;
    }
}