package com.tacoloco.model;

import java.util.List;

public class Order {
    private List<Item> items;

    public Order() {}

    public Order(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
