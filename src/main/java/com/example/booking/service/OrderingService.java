package com.example.booking.service;

import com.example.booking.entity.Book;
import com.example.booking.entity.Order;
import com.example.booking.entity.User;
import com.example.booking.interfaces.GenericCrudService;
import com.example.booking.payload.BookDto;
import com.example.booking.payload.OrderDto;
import com.example.booking.repository.BookRepository;
import com.example.booking.repository.OrderRepository;
import com.example.booking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderingService implements GenericCrudService<Order, OrderDto> {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    @Override
    public Order create(OrderDto orderDto) {
       return null;

    }

    @Override
    public Order get() {
        return null;
    }

    @Override
    public Order update(Integer id) {
        return null;
    }

    @Override
    public void delete() {

    }
}
