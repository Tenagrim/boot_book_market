package com.market.book_market.service.impl;

import com.market.book_market.mappers.UserMapper;
import com.market.book_market.models.dto.RoleDto;
import com.market.book_market.models.requests.UserRq;
import com.market.book_market.models.responses.UserRs;
import com.market.book_market.repository.RoleRepository;
import com.market.book_market.repository.UserRepository;
import com.market.book_market.models.entity.Role;
import com.market.book_market.models.entity.User;
import com.market.book_market.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public List<UserRs> getAllUsers() { return userMapper.toUserRsList(userRepository.findAll()); }

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
    public void saveUser(UserRq userRq) {
        User user = userMapper.toEntity(userRq);
        User fromDB = userRepository.findByUsername(user.getUsername());
        if (fromDB != null)
            return;
        if (user.getRoles() == null)
            user.setRoles(Collections.singleton(new Role(RoleDto.USER.toString())));
        for (Role r : user.getRoles()) {
            Role userRole = roleRepository.findByName(r.getName());
            if (userRole == null)
                roleRepository.save(r);
            else
                r.setId(userRole.getId());
        }
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
