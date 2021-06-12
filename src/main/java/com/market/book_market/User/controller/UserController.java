package com.market.book_market.User.controller;


import com.market.book_market.User.Exception_handler.NoSuchUser;
import com.market.book_market.User.Exception_handler.UserWrongData;
import com.market.book_market.User.entity.User;
import com.market.book_market.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> showAllUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getOneUser(@PathVariable int id) {
        User user = userService.getOneUser(id);

        if (user == null){
            throw new NoSuchUser("There Is no User with ID " + id);
        }
        return user;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public String deletaUser(@PathVariable int id){
        userService.deleteUser(id);
        return ("User with id = " + id + " Deleted!");
    }

    @ExceptionHandler
    public ResponseEntity<UserWrongData> handleException (
            NoSuchUser exception) {
        UserWrongData data = new UserWrongData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
}
