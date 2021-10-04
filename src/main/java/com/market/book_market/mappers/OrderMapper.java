package com.market.book_market.mappers;

import com.market.book_market.models.entity.Order;
import com.market.book_market.models.requests.OrderRq;
import com.market.book_market.models.responses.OrderRs;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {BookMapper.class})
public interface OrderMapper {
    @Mapping(target = "user", expression = "java(order.getUser().getUsername())")
    OrderRs toDto(Order order);
    Order toEntity(OrderRq order);
    List<OrderRs> toDtoList(List<Order> orders);
}