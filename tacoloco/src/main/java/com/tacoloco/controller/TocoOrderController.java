package com.tacoloco.controller;

import com.tacoloco.model.Order;
import com.tacoloco.service.TocoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class TocoOrderController {

    @Autowired
    private TocoOrderService tocoOrderService;

    @PostMapping("/total")
    public ResponseEntity<Map<String, Integer>> calculateOrderTotal(@RequestBody Order order) {
        int total = tocoOrderService.calculateTotal(order);
        Map<String, Integer> response = new HashMap<>();
        response.put("totalPrice", total);
        return ResponseEntity.ok(response);
    }
}
