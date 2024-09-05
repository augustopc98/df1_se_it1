package com.example.demo.services;

import com.example.demo.entities.CustomOrder;

import java.util.Date;
import java.util.List;

public interface ICustomOrderService {
    CustomOrder createOrder(Long id, String customerEmail, String customerAddress, Date orderDate);
    void updateDeliveryStatus(Long orderId, String status);
    void sendOrderForDelivery(Long orderId);
    CustomOrder getOrder(Long orderId);
    List<CustomOrder> getAllOrders();
}
