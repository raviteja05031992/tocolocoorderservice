package com.tacoloco.service;

import com.tacoloco.model.Item;
import com.tacoloco.model.Order;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TocoOrderService {

    private static final Map<String, Integer> PRICES = new HashMap<>();

    static {
        PRICES.put("Veggie Taco", 250);
        PRICES.put("Chicken Taco", 300);
        PRICES.put("Chorizo Taco", 350);
    }

    public int calculateTotal(Order order) {
        int totalTacos = 0;
        int totalPrice = 0;

        for (Item item : order.getItems()) {
            int price = PRICES.getOrDefault(item.getName(), 0);
            int itemTotal = item.getQuantity() * price;
            totalPrice += itemTotal;
            totalTacos += item.getQuantity();
        }

        // Apply a 20% discount if 4 or more tacos are ordered
        if (totalTacos >= 4) {
            totalPrice = totalPrice - (totalPrice * 20 / 100);
        }

        return totalPrice;
    }
}
