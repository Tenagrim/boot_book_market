package com.market.book_market.models.responses;

import com.market.book_market.models.dto.RoleDto;
import lombok.Data;

import java.util.Set;

@Data
public class UserRs {
    int id;
    private String username;
    private String email;
    private Set<RoleDto> roles;
}
