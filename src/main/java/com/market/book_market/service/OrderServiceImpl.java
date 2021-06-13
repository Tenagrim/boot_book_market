package com.market.book_market.service;

import com.market.book_market.dao.OrderRepository;
import com.market.book_market.dao.UserRepository;
import com.market.book_market.entity.Book;
import com.market.book_market.entity.Order;
import com.market.book_market.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrder(int id) {
        Order order = null;
        Optional<Order> data = orderRepository.findById(id);
        if(data.isPresent()){
            order = data.get();
        }
        return order;
    }

    @Override
    public Order saveOrder(Order order) {
        User user = order.getUser();
        List<Book> bookList = order.getBookList();

        if (user != null && user.getUser_id() == 0){
            if (user.getUsername() == null)
                return null;
            User find = userRepository.findUserByUsername(user.getUsername());
            if(find != null)
                order.setUser(user);
            else
                userRepository.save(user);
        }

        for (Book book : bookList) {
            if(book.getId() == 0) {
               return null;
            }
        }

        orderRepository.save(order);
        return order;
    }

    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
}
