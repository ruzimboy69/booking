package com.example.booking.interfaces;

public interface GenericCrudService<T, D> {
    //D generic parameter type
    //T genereic object type
    T create(D dto);

    T get();

    T update(Integer id);

    void delete();
}
