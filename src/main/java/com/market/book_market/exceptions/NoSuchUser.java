package com.market.book_market.exceptions;

public class NoSuchUser extends RuntimeException{
    public NoSuchUser(String message) {
        super(message);
    }
}
