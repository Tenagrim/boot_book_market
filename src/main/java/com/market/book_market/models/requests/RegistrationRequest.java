package com.market.book_market.models.requests;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class RegistrationRequest {
    @NotEmpty(message = "Имя не может быть пустым")
    private String username;
    @NotEmpty(message = "Пароль не может быть пустым")
    private String password;
    @Email(message = "email должен иметь формат адреса электронной почты")
    private String email;
}
