package com.example.service;

import com.example.model.Order;
import com.example.repository.OrderDao;

public class OrderService {
    private final OrderDao orderDao;

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void createOrder(Order order) {
        orderDao.saveOrder(order);
    }
} 