package com.market.book_market.dao;

import com.market.book_market.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO{

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Book> getAllBooks() {

        Query query = entityManager.createQuery("from Book");
        List<Book> allBooks = query.getResultList();
        return allBooks;
    }
}
