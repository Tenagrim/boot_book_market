package com.market.book_market.service;

import com.market.book_market.entity.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    public List<Book> getAllBooks();
    public Book saveBook(Book book);


    public Book getOneBook(int id);
    public void deleteBook(int id);
}
