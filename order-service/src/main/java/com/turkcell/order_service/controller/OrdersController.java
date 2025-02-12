package com.turkcell.order_service.controller;

import com.turkcell.order_service.client.ProductClient;
import com.turkcell.order_service.entity.Order;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        // Syncİletişim
        //String response = productClient.get();
        //System.out.println(response);

        // TODO: Kafkadan common bir classı gönder.
        Order order = new Order();
        order.setId("abc123");
        //

        streamBridge.send("orderCreatedFunction-out-0", "Mesaj123");
        return "Order Service";
    }
}
