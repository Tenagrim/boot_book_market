package com.market.book_market.service;

import com.market.book_market.models.entity.Book;
import com.market.book_market.models.requests.BookRq;
import com.market.book_market.models.responses.BookRs;

import java.util.List;

public interface BookService {
    public List<BookRs> getAllBooks();
    public Book saveBook(BookRq book);


    public BookRs getOneBook(int id);
    public void deleteBook(int id);
}
