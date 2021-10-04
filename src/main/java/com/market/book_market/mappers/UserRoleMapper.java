package com.market.book_market.mappers;

import com.market.book_market.models.dto.RoleDto;
import com.market.book_market.models.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;

@Mapper
public abstract class UserRoleMapper {
    RoleDto toDto(Role role){
        return RoleDto.valueOf(role.getName().substring(5));
    }
    abstract Set<RoleDto> toDtoSet(Set<Role> roles);

    @Mapping(target = "name", expression = "java(role.toString())")
    abstract Role toEntity(RoleDto role);

}
