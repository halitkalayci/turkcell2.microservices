package com.turkcell.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.productservice.clients.ExampleClient;

@RestController
@RequestMapping("/api/v1/products")
public class ProductsController
{
    private final ExampleClient exampleClient;
    public ProductsController(ExampleClient exampleClient) {
        this.exampleClient = exampleClient;
    }
    @GetMapping
    public String get() {
        //Object response = exampleClient.get();
        //System.out.println(response);
        System.out.println("Processing..");
        return "Product Service";
    }
}
