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

    @Override
    public void saveBook(Book book) {
        entityManager.merge(book);
    }

    @Override
    public Book getBook(int id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public void deleteBook(int id) {
        Query query = entityManager.createQuery("delete from Book where id =: bookId");
        query.setParameter("bookId", id);
        query.executeUpdate();
    }
}
