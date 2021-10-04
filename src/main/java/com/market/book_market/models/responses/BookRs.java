package com.market.book_market.models.responses;

import lombok.Value;

@Value
public class BookRs {
    int id;
    String title;
    String genre;
    String author;
    double price;
}
