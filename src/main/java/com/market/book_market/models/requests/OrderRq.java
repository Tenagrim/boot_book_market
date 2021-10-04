package com.market.book_market.models.requests;

import lombok.Data;

import java.util.List;

@Data
public class OrderRq {
    String username;
    String description;
    List<Integer> bookIds;
}
