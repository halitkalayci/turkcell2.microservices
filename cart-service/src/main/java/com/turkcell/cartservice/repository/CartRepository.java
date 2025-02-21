package com.turkcell.cartservice.repository;

import com.turkcell.cartservice.entity.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends MongoRepository<Cart, String> {
    Optional<Cart> findByCustomerFullName(String customerFullName);

    @Query("{'totalPrice': {'$gte': ?0 }}")
    List<Cart> findByTotalPriceGreaterThan(float totalPrice);
}
