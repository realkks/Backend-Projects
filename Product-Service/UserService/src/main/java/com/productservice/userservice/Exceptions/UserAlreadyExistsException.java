package com.productservice.userservice.Exceptions;

// Exception class for if user already exists at signup
public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
