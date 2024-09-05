package com.example.demo.controllers;

import com.example.demo.entities.CustomOrder;
import com.example.demo.services.ICustomOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class CustomOrderController {

    private final ICustomOrderService orderService;

    @Autowired
    public CustomOrderController(ICustomOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public CustomOrder createOrder(@RequestParam Long id, @RequestParam String customerEmail,
                                   @RequestParam String customerAddress, @RequestParam Date orderDate) {
        return orderService.createOrder(id, customerEmail, customerAddress, orderDate);
    }

    @PutMapping("/{orderId}/status")
    public void updateDeliveryStatus(@PathVariable Long orderId, @RequestParam String status) {
        orderService.updateDeliveryStatus(orderId, status);
    }

    @PutMapping("/{orderId}/deliver")
    public void sendOrderForDelivery(@PathVariable Long orderId) {
        orderService.sendOrderForDelivery(orderId);
    }

    @GetMapping("/{orderId}")
    public CustomOrder getOrder(@PathVariable Long orderId) {
        return orderService.getOrder(orderId);
    }

    @GetMapping
    public List<CustomOrder> getAllOrders() {
        return orderService.getAllOrders();
    }
}
