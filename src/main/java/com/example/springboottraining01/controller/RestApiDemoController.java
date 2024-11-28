package com.example.springboottraining01.controller;

import com.example.springboottraining01.CheckModifyCoffee;
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
        CheckModifyCoffee result = coffeeList.addCoffee(coffee);
        return result.getCoffee();
    }

    @PutMapping("/coffees/{id}")
    ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        CheckModifyCoffee result = coffeeList.modifyCoffee(coffee);
        return (result.getTypeModify()) ?
                new ResponseEntity<>(result.getCoffee(), HttpStatus.OK) :
                new ResponseEntity<>(result.getCoffee(), HttpStatus.CREATED);
    }

    @DeleteMapping("/coffees/{id}")
    void deleteCoffee(@PathVariable String id) {
        coffeeList.deleteCoffee(id);
    }
}
