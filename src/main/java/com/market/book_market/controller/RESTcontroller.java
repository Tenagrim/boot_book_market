package com.market.book_market.controller;



import com.market.book_market.entity.Book;
import com.market.book_market.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTcontroller {



    @Autowired
    private BookService bookService;



    @GetMapping("/books")
    public List<Book> showAllBook() {
        return bookService.getAllBooks();
    }

    @PostMapping("/books")
    public Book addNewBook(@RequestBody Book book)
    {
        bookService.saveBook(book);
        return book;
    }
}
