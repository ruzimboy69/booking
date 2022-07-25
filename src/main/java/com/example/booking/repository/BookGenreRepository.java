package com.example.booking.repository;

import com.example.booking.entity.BookGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookGenreRepository extends JpaRepository<BookGenre,Integer> {
}
