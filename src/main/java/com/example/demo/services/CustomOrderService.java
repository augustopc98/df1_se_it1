package com.example.demo.services;

import com.example.demo.entities.CustomOrder;
import com.example.demo.repositories.ICustomOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomOrderService implements ICustomOrderService {

    private final ICustomOrderRepository orderRepository;

    @Autowired
    public CustomOrderService(ICustomOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public CustomOrder createOrder(Long id, String customerEmail, String customerAddress, Date orderDate) {
        CustomOrder order = new CustomOrder(id, customerEmail, customerAddress, orderDate);
        return orderRepository.save(order);
    }

    @Override
    public void updateDeliveryStatus(Long orderId, String status) {
        CustomOrder order = orderRepository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("Invalid Order ID"));
        order.updateDeliveryStatus(status);
        orderRepository.save(order);
    }

    @Override
    public void sendOrderForDelivery(Long orderId) {
        CustomOrder order = orderRepository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("Invalid Order ID"));
        order.sendForDelivery();
        orderRepository.save(order);
    }

    @Override
    public CustomOrder getOrder(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new IllegalArgumentException("Invalid Order ID"));
    }

    @Override
    public List<CustomOrder> getAllOrders() {
        return orderRepository.findAll();
    }
}
