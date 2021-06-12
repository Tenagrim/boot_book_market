package com.market.book_market.User.service;

import com.market.book_market.User.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getOneUser(int id);
    public void saveUser(User user);
    void deleteUser(int id);
}
