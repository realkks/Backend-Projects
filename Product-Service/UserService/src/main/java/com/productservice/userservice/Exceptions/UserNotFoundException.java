package com.productservice.userservice.Exceptions;

import org.springframework.context.annotation.Configuration;


public class UserNotFoundException extends Exception {

    public UserNotFoundException(String message) {
        super(message);
    }
}
