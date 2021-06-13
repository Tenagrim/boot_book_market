package com.market.book_market.service;

import com.market.book_market.dao.RoleRepository;
import com.market.book_market.dao.UserRepository;
import com.market.book_market.entity.Role;
import com.market.book_market.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.*;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

        User fromDB = userRepository.findByUsername(user.getUsername());
        if (fromDB != null)
            return;

        Role userRole = roleRepository.findByName("ROLE_USER");
        if (userRole == null) {
            userRole = new Role("ROLE_USER");
            roleRepository.save(userRole);
        }
        Set<Role> roles = new HashSet<Role>();
        roles.add(userRole);
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {

        User userEntity = findByUsername(username);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }
}
