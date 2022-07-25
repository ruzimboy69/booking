package com.example.booking;

import com.example.booking.entity.Book;
import com.example.booking.mappers.BookMapper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.provider.HibernateUtils;

@SpringBootApplication
public class BookingApplication {

    public static void main(String[] args) {

        SpringApplication.run(BookingApplication.class, args);

    }


}
