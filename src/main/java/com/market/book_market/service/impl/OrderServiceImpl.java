package com.market.book_market.service.impl;

import com.market.book_market.exceptions.NotFoundException;
import com.market.book_market.mappers.OrderMapper;
import com.market.book_market.models.requests.OrderRq;
import com.market.book_market.models.responses.OrderRs;
import com.market.book_market.repository.OrderRepository;
import com.market.book_market.repository.UserRepository;
import com.market.book_market.models.entity.Book;
import com.market.book_market.models.entity.Order;
import com.market.book_market.models.entity.User;
import com.market.book_market.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderMapper orderMapper;

    @Override
    public List<OrderRs> getAllOrders() {
        return orderMapper.toDtoList(orderRepository.findAll());
    }

    @Override
    public OrderRs getOrder(int id) {
        Order order = null;
        Optional<Order> data = orderRepository.findById(id);
        if(data.isPresent()){
            order = data.get();
        }
        return orderMapper.toDto(order);
    }

    @Override
    public Order saveOrder(OrderRq orderRq) throws NotFoundException {
        Order order = new Order();
        User find = userRepository.findUserByUsername(orderRq.getUsername());
        if(find == null)
            throw new NotFoundException();
        order.setUser(find);

        List<Book> books = new ArrayList<>();
        for (Integer id : orderRq.getBookIds())
            books.add(new Book(id));
        order.setBookList(books);
        order.setDescription(orderRq.getDescription());
        order.setDate(LocalDateTime.now().toString());
        orderRepository.save(order);
        return order;
    }

    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
}
