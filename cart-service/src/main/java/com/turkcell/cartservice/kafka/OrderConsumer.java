package com.turkcell.cartservice.kafka;

import io.github.halitkalayci.event.order.OrderCreatedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class OrderConsumer {
    @Bean
    public Consumer<OrderCreatedEvent> orderCreatedFunction() {
        return event -> System.out.println(event.getOrderID() + " " + event.getOrderDate().toString());
    }
}
