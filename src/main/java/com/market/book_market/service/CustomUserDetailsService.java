package com.market.book_market.service;

import com.market.book_market.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userService.findByUsername(username);
        return userEntity;
    }
}
