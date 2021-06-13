package com.market.book_market.service;

import com.market.book_market.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getOneUser(int id);
    public void saveUser(User user);
    public void deleteUser(int id);
}
