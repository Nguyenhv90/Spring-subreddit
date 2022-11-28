package com.hvn.springsubredditbackend.config.exceptions;

public class SubredditNotFoundException extends RuntimeException {
    public SubredditNotFoundException(String exMessage) {
        super(exMessage);
    }
}
