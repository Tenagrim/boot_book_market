package com.market.book_market.repository;

import com.market.book_market.models.entity.Author;
import com.market.book_market.models.entity.Book;
import com.market.book_market.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
