package com.example.springboottraining01.controller;

import com.example.springboottraining01.service.CheckModifyCoffee;
import com.example.springboottraining01.service.Coffee;
import com.example.springboottraining01.service.CoffeeList;
import com.example.springboottraining01.service.TransformIntoHttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coffees")
public class RestApiDemoController {
    private final CoffeeList coffeeList;

    private RestApiDemoController(CoffeeList coffeeList) {
        this.coffeeList = coffeeList;
    }

    @GetMapping
    Iterable<Coffee> getCoffees() {
        return coffeeList.getCoffees();
    }

    @GetMapping("/{id}")
    Iterable<Coffee> getCoffeeById(@PathVariable String id) {
        return coffeeList.getCoffeeById(id).stream().toList();
    }

    @PostMapping
    ResponseEntity<Coffee> postCoffee(@RequestBody Coffee coffee) {
        return getCreatedResponseEntity(coffeeList.addCoffee(coffee));
    }

    @PutMapping("/{id}")
    ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        return getCreatedResponseEntity(coffeeList.setCoffee(id, coffee));
    }

    @DeleteMapping("/{id}")
    void deleteCoffee(@PathVariable String id) {
        coffeeList.deleteCoffee(id);
    }

    private ResponseEntity<Coffee> getCreatedResponseEntity(CheckModifyCoffee checkModifyCoffee) {
        return new ResponseEntity<>(
                checkModifyCoffee.coffee(),
                TransformIntoHttpStatus.getHttpStatus(checkModifyCoffee.typeModify()));
    }
}
