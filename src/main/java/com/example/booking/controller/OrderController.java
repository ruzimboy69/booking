package com.example.booking.controller;

import com.example.booking.entity.Order;
import com.example.booking.payload.OrderDto;
import com.example.booking.repository.OrderRepository;
import com.example.booking.service.OrderingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderingService orderingService;
    @PostMapping
    public HttpEntity<?> addOrder(@RequestBody OrderDto orderDto){
        Order order = orderingService.create(orderDto);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }
}
