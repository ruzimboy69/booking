package com.example.booking.repository;

import com.example.booking.entity.Book;
import com.example.booking.entity.BookGenre;
import com.example.booking.interfaces.Persistable;
import com.example.booking.interfaces.Removable;
import com.example.booking.interfaces.Searchable;
import com.example.booking.payload.BookGenreDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends Searchable<Book,Integer>, Persistable<Book>, Removable<Book>, JpaRepository<Book,Integer> {
    @Override
    Book save(Book book);

    @Override
    List<Book> findAll();

    @Override
    Book findByid(Integer id);

    @Override
    void delete(Book book);

    Optional<Book> findByTitle(String title);
    List<Book> findAllByTitle(String title);
    List<Book> findAllByBookGenreId(Integer id);
    @Query(value = "select *  from Book b where  upper(b.AuhtorName) = :authorname or lower(b.AuhtorName )=:authorName ",nativeQuery = true)
    List<Book> findAllByAuthorNameIsContaining(String authorName);
}
