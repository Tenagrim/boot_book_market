package com.market.book_market.service;

import com.market.book_market.entity.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getAllOrders();
    public Order getOrder(int id);
    public Order saveOrder(Order order);
    public void deleteOrder(int id);
}
