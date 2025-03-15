package com.turkcell.order_service.controller;

import com.turkcell.order_service.client.ProductClient;
import com.turkcell.order_service.entity.Order;
import io.github.halitkalayci.event.order.OrderCreatedEvent;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {
    private final ProductClient productClient;
    private final StreamBridge streamBridge;

    public OrdersController(ProductClient productClient, StreamBridge streamBridge) {
        this.productClient = productClient;
        this.streamBridge = streamBridge;
    }

    @GetMapping
    public String get() {
        String response = productClient.get();
        System.out.println(response);    

        return "Order Service";
    }
}
