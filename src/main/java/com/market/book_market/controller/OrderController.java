package com.market.book_market.controller;

import com.market.book_market.exceptions.NotFoundException;
import com.market.book_market.models.entity.Order;
import com.market.book_market.models.requests.OrderRq;
import com.market.book_market.models.responses.OrderRs;
import com.market.book_market.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderRs> showAllOrders() { return orderService.getAllOrders(); }

    @GetMapping("/{id}")
    public OrderRs getOneOrder(@PathVariable int id){
        return orderService.getOrder(id);
    }

    @PostMapping
    public ResponseEntity addNewOrder(@RequestBody OrderRq order) throws NotFoundException {
         orderService.saveOrder(order);
        return ResponseEntity.ok().build();
    }
}
