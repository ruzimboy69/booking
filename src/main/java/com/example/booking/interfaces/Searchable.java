package com.example.booking.interfaces;

import com.example.booking.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Searchable <T,ID>{
    List<T> findAll();
    T findByid(ID id);

}
