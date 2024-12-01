package com.example.springboottraining01.controller;

import com.example.springboottraining01.CheckModifyCoffee;
import com.example.springboottraining01.Coffee;
import com.example.springboottraining01.CoffeeList;
import com.example.springboottraining01.TransformIntoHttpStatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

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
        return coffeeList.getCoffeeById(id).stream().toList();
    }

    @PostMapping("/coffees")
    ResponseEntity<Coffee> postCoffee(@RequestBody Coffee coffee) {
        return getCcreatedResponseEntity(coffeeList.addCoffee(coffee));
    }

    @PutMapping("/coffees/{id}")
    ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        return getCcreatedResponseEntity(coffeeList.setCoffee(id, coffee));
    }

    @DeleteMapping("/coffees/{id}")
    void deleteCoffee(@PathVariable String id) {
        coffeeList.deleteCoffee(id);
    }

    private ResponseEntity<Coffee> getCcreatedResponseEntity(CheckModifyCoffee checkModifyCoffee) {
        return new ResponseEntity<>(checkModifyCoffee.coffee(),
                HttpStatus.valueOf(TransformIntoHttpStatusCode.getTransValue(checkModifyCoffee.typeModify())));
    }
}
