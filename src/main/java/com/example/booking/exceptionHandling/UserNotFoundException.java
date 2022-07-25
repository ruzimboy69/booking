package com.example.booking.exceptionHandling;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String username){
        super(username);
    }
}
