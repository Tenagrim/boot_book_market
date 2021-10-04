package com.market.book_market.models.requests;

import com.market.book_market.models.dto.RoleDto;
import com.market.book_market.models.entity.Role;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Builder
public class UserRq {
    @NotEmpty(message = "Имя не может быть пустым")
    private String username;
    @NotEmpty(message = "Пароль не может быть пустым")
    private String password;
    @Email(message = "email должен иметь формат адреса электронной почты")
    private String email;
    private Set<RoleDto> roles;
}
