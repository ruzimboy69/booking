package com.example.booking.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

     private String AuthorName;

    @ManyToOne
//    @JoinColumn(name = "bookGenre_id")
     private BookGenre bookGenre;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "Order_id")
//    private Order order;

}
