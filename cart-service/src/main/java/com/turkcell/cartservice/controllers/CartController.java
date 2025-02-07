package com.turkcell.cartservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    @GetMapping
    public String get() {
        System.out.println("get called");
        return "Cart Service";
    }
}
