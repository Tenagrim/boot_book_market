package com.market.book_market.service;

import com.market.book_market.exceptions.NotFoundException;
import com.market.book_market.models.entity.Order;
import com.market.book_market.models.requests.OrderRq;
import com.market.book_market.models.responses.OrderRs;

import java.util.List;

public interface OrderService {
    public List<OrderRs> getAllOrders();
    public OrderRs getOrder(int id);
    public Order saveOrder(OrderRq order) throws NotFoundException;
    public void deleteOrder(int id);
}
