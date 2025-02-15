package io.github.halitkalayci.event.order;

import java.time.LocalDate;

public class OrderCreatedEvent {
    private String orderID;
    private LocalDate orderDate;

    public OrderCreatedEvent() {
    }

    public OrderCreatedEvent(String orderID, LocalDate orderDate) {
        this.orderID = orderID;
        this.orderDate = orderDate;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
