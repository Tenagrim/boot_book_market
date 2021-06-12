package com.market.book_market.User.dao;

import com.market.book_market.User.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();
    public User getOneUser(int id);
    public void saveUser(User user);
    public void deleteUser(int id);
}