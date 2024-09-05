package com.example.demo.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CustomOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerEmail;
    private String customerAddress;
    private Date orderDate;
    private String deliveryStatus;

    public CustomOrder() {}

    public CustomOrder(Long id, String customerEmail, String customerAddress, Date orderDate) {
        this.id = id;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.orderDate = orderDate;
        this.deliveryStatus = "Pending";
    }

    public void updateDeliveryStatus(String status) {
        this.deliveryStatus = status;
    }

    public void sendForDelivery() {
        this.deliveryStatus = "Out for delivery";
    }

    public Long getId() {
        return id;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }
}
