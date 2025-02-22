package com.turkcell.cartservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("carts")
public class Cart {
    @Id
    private String id;
    private String customerFullName;
    private float totalPrice;
    private Product product;
    public Cart() {
    }

    public Cart(String id, String customerFullName, float totalPrice) {
        this.id = id;
        this.customerFullName = customerFullName;
        this.totalPrice = totalPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}

