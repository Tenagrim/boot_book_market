package com.market.book_market.controller;

import com.market.book_market.entity.Book;
import com.market.book_market.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> showAllBook() {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getOneBook(@PathVariable int id) {
        Book book = bookService.getOneBook(id);
        return book;
    }

    @PostMapping("/books")
    public Book addNewBook(@RequestBody Book book)
    {
        Book resp = bookService.saveBook(book);
        return resp;
    }

    @PutMapping("/books")
    public Book updateUser(@RequestBody Book book) {
        bookService.saveBook(book);
        return book;
    }

    @DeleteMapping("/books/{id}")
    public void deleteUser(@PathVariable int id){
        bookService.deleteBook(id);
    }

}
