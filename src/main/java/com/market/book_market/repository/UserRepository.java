package com.market.book_market.repository;

import com.market.book_market.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByBalance(double balance);
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
    User findUserByUsername(String username);
}