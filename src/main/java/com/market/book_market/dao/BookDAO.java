package com.market.book_market.dao;

import com.market.book_market.entity.Book;

import java.util.List;

public interface BookDAO {
    public List<Book> getAllBooks();
    public void saveBook(Book book);
    public Book getBook(int id);
    public void deleteBook(int id);
}
