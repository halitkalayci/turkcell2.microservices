package com.turkcell.cartservice.controller;

import com.turkcell.cartservice.entity.Cart;
import com.turkcell.cartservice.repository.CartRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    private final CartRepository cartRepository;

    public CartController(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @GetMapping
    public Cart get(@RequestParam String name) {
        return this.cartRepository.findByCustomerFullName(name).orElseThrow();
    }

    @GetMapping("price")
    public List<Cart> getByPrice(@RequestParam float price)
    {
        return this.cartRepository.findByTotalPriceGreaterThan(price);
    }

    @PostMapping
    public void add(@RequestBody Cart cart) { // DTO OLMALI
        this.cartRepository.save(cart); // Servise gitmeli
    }
}
