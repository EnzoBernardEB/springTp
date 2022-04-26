package com.example.tp1.service;

import com.example.tp1.exception.StockException;
import com.example.tp1.model.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getAllOrders();
    public Order create(Order order);
    public void update(Order order) throws StockException;
}
