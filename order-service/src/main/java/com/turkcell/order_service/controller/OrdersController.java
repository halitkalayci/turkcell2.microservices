package com.turkcell.order_service.controller;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {
    @LoadBalanced
    private final RestClient restClient;

    public OrdersController(RestClient.Builder restClientBuilder) {
        restClient = restClientBuilder.baseUrl("http://localhost:8084").build();
    }

    @GetMapping
    public String get() {
        // istek at
        // anında cevap al (cevabı bekle)
        // cevabı işle (sync)
        String response = restClient.get().uri("/api/v1/products").retrieve().body(String.class);
        System.out.println("Product serviceden gelen cevap: " + response);
        // mesajı gönder ve işleme devam et (async)
        return "Order Service";
    }
}
