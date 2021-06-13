package com.market.book_market.controller;


import com.market.book_market.Exception_handler.NoSuchUser;
import com.market.book_market.Exception_handler.UserWrongData;
import com.market.book_market.entity.User;
import com.market.book_market.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Get all Users")
    @ApiResponse(responseCode = "200", description = "Return Users List", content = {
            @Content(mediaType = "application/json",
            schema = @Schema(implementation = User.class))
    })
    @GetMapping("/users")
    public List<User> showAllUser() {
        return userService.getAllUsers();
    }

    @Operation(summary = "Get user by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Return User by ID", content = {
                    @Content(mediaType = "application/json",
                    schema = @Schema(implementation = User.class))
            }),
            @ApiResponse(responseCode = "400", description = "None user with this ID", content = {
                    @Content(mediaType = "application/json")
            })
    })
    @GetMapping("/users/{id}")
    public User getOneUser(@Parameter(description = "id of user")@PathVariable int id) {
        User user = userService.getOneUser(id);

        if (user == null){
            throw new NoSuchUser("There Is no User with ID " + id);
        }
        return user;
    }

    @Operation(summary = "Create new User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create New User", content = {
                    @Content(mediaType = "application/json",
                    schema = @Schema(implementation = User.class))
            })
    })
    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @Operation(summary = "Update User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Update New User", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class))
            })
    })
    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @Operation(summary = "Delete User By Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Delete New User", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = User.class))
            })
    })
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id){
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
