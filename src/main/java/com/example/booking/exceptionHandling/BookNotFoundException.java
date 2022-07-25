package com.example.booking.exceptionHandling;

public class BookNotFoundException extends Exception{

    public BookNotFoundException(String title){
        super(title);
    }
}
