package com.market.book_market.models.responses;

import lombok.Data;

import java.util.List;

@Data
public class OrderRs {
    String description;
    String date;
    String user;
    List<BookRs> bookList;
}
