package com.market.book_market.models.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RoleDto {
    ADMIN,
    USER;

    @Override
    public String toString() {
        return "ROLE_" + name();
    }
}
