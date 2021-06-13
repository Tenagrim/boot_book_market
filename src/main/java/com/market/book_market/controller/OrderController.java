package com.market.book_market.controller;

import com.market.book_market.entity.Order;
import com.market.book_market.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<Order> showAllOrders() { return orderService.getAllOrders(); }

    @GetMapping("/orders/{id}")
    public Order getOneOrder(@PathVariable int id){
        Order order = orderService.getOrder(id);
        return order;
    }

    @PostMapping("/orders")
    public Order addNewOrder(@RequestBody Order order)
    {
        System.out.println(order.toString());
        Order resp = orderService.saveOrder(order);
        return resp;
    }
}
