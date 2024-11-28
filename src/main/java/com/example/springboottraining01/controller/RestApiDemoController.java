package com.example.springboottraining01.controller;

import com.example.springboottraining01.Coffee;
import com.example.springboottraining01.CoffeeList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        return (coffeeList.modifyCoffee(id, coffee)) ?
                new ResponseEntity<>(coffee, HttpStatus.OK) :
                new ResponseEntity<>(coffee, HttpStatus.CREATED);
    }

    @DeleteMapping("/coffees/{id}")
    void deleteCoffee(@PathVariable String id) {
        coffeeList.deleteCoffee(id);
    }
}
