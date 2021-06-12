package com.market.book_market.controller;


import com.market.book_market.entity.User;
import com.market.book_market.entity.Book;
import com.market.book_market.service.BookService;
import com.market.book_market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTcontroller {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @GetMapping("/users")
    public List<User> showAllUser() {
        return userService.getAllUsers();
    }


    @GetMapping("/books")
    public List<Book> showAllBook() {
        return bookService.getAllBooks();
    }
}
