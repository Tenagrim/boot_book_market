package com.market.book_market.controller;

import com.market.book_market.configuration.jwt.JwtProvider;
import com.market.book_market.mappers.UserMapper;
import com.market.book_market.models.entity.User;
import com.market.book_market.models.requests.AuthResponse;
import com.market.book_market.models.requests.AuthorizationRequest;
import com.market.book_market.models.requests.RegistrationRequest;
import com.market.book_market.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtProvider jwtProvider;
    private final UserMapper userMapper;

    @Operation(summary = "Register")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Registration")
    })
    @PostMapping("/signup")
    public ResponseEntity sginUp(@Valid @RequestBody RegistrationRequest registrationRequest)
    {
        userService.saveUser(userMapper.toUserRq(registrationRequest));
        return ResponseEntity.ok().build();
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
