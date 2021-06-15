package com.market.book_market.controller;

import com.market.book_market.configuration.jwt.JwtProvider;
import com.market.book_market.entity.Book;
import com.market.book_market.entity.User;
import com.market.book_market.requests.AuthResponse;
import com.market.book_market.requests.AuthorizationRequest;
import com.market.book_market.requests.RegistrationRequest;
import com.market.book_market.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;

    @Operation(summary = "Register")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Registration", content = {
                    @Content(mediaType = "text")
            })
    })
    @PostMapping("/signup")
    public String sginUp(@RequestBody RegistrationRequest registrationRequest)
    {
        User user = new User();
        user.setPassword(registrationRequest.getPassword());
        user.setUsername(registrationRequest.getUsername());
        user.setEmail(registrationRequest.getEmail());
        userService.saveUser(user);
        return "OK";
    }

    @Operation(summary = "Get auth token")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get auth token", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AuthResponse.class))
            })
    })
    @PostMapping("/signin")
    public AuthResponse auth(@RequestBody AuthorizationRequest request) {
        User userEntity = userService.findByUsernameAndPassword(request.getUsername(), request.getPassword());
        if(userEntity == null)
            return new AuthResponse("Wrong data");
        String token = jwtProvider.generateToken(userEntity.getUsername());
        return new AuthResponse(token);
    }

}
