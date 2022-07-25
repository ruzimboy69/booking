package com.example.booking.entity;


import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.annotation.Target;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "orders")
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Order_id")
    private Integer id;
    private String orderNumber;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Book> bookList;


}
