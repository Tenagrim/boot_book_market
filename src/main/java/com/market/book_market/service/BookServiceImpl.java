package com.market.book_market.service;

import com.market.book_market.dao.BookDAO;
import com.market.book_market.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDAO bookDAO;

    @Override
    @Transactional
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }
}
