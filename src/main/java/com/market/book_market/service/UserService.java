package com.market.book_market.service;

import com.market.book_market.models.entity.User;
import com.market.book_market.models.requests.UserRq;
import com.market.book_market.models.responses.UserRs;

import java.util.List;

public interface UserService {
    public List<UserRs> getAllUsers();
    public User getOneUser(int id);
    public void saveUser(UserRq user);
    public void deleteUser(int id);

    List<User> findAllByBalance(double balance);
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
}
