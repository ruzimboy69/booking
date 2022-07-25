package com.example.booking.repository;

import com.example.booking.entity.Order;
import com.example.booking.interfaces.Persistable;
import com.example.booking.interfaces.Searchable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends Persistable<Order>, Searchable<Order,Integer>, JpaRepository<Order,Integer> {
    @Override
    List<Order> findAll();

    @Override
    Order findByid(Integer id);

    @Override
    Order save(Order order);
}
