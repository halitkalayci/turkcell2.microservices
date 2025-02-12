package com.turkcell.cartservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CartServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CartServiceApplication.class, args);
    }

}

// Common paket(ler)i nasıl implemente edilir yolları nelerdir?
// Size mantıklı geleni projemize implente etmeye çalışalım.

// Parent project
// Bağımsız repository projesi + 1