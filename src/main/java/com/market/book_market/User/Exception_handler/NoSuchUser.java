package com.market.book_market.User.Exception_handler;

public class NoSuchUser extends RuntimeException{
    public NoSuchUser(String message) {
        super(message);
    }
}
