package com.market.book_market.service;

import com.market.book_market.dao.UserRepository;
import com.market.book_market.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() { return userRepository.findAll(); }

    @Override
    public User getOneUser(int id) {
        User user = null;
        Optional<User> data = userRepository.findById(id);
        if (data.isPresent()){
            user = data.get();
        }
        return user;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAllByBalance(double balance) {
        return userRepository.findAllByBalance(balance);
    }
}
