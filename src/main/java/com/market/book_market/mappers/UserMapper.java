package com.market.book_market.mappers;

import com.market.book_market.models.entity.User;
import com.market.book_market.models.requests.RegistrationRequest;
import com.market.book_market.models.requests.UserRq;
import com.market.book_market.models.responses.UserRs;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {UserRoleMapper.class})
public interface UserMapper {
    @Mapping(target = "roles", source = "roles")
    UserRs toUserRs(User user);
    @Mapping(target = "roles", source = "roles")
    List<UserRs> toUserRsList(List<User> user);
    User toEntity(UserRq user);
    UserRq toUserRq(RegistrationRequest request);
}
