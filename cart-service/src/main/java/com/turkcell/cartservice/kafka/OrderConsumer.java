package com.turkcell.cartservice.kafka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class OrderConsumer {
    @Bean
    public Consumer<String> orderCreatedFunction() {
        return message -> System.out.println(message);
    }
}
