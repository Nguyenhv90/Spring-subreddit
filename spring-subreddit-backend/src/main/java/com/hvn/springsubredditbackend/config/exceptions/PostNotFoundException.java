package com.hvn.springsubredditbackend.config.exceptions;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(String exMessage) {
        super(exMessage);
    }
}
