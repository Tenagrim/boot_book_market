package com.market.book_market.models.requests;

import lombok.Data;

@Data
public class BookRq {
    String title;
    String genre;
    String author;
    double price;
}
