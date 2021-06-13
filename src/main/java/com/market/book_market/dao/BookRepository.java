package com.market.book_market.dao;

import com.market.book_market.entity.Author;
import com.market.book_market.entity.Book;
import com.market.book_market.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
