package com.example.booking.interfaces;

public interface Persistable<T> {
    T save(T t);
}
