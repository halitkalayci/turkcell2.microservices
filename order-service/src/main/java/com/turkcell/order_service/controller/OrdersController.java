package com.turkcell.order_service.controller;

import com.turkcell.order_service.client.ProductClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {
    private final ProductClient productClient;

    public OrdersController(ProductClient productClient) {
        this.productClient = productClient;
    }

    @GetMapping
    public String get() {
        String response = productClient.get();
        System.out.println(response);
        return "Order Service";
    }
}
