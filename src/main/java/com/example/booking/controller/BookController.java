package com.example.booking.controller;

import com.example.booking.entity.Book;
import com.example.booking.entity.BookGenre;
import com.example.booking.payload.BookDto;
import com.example.booking.payload.BookGenreDto;
import com.example.booking.repository.BookRepository;
import com.example.booking.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/book")
public class BookController {

  final BookService bookService;
  final BookRepository bookRepository;

    @PostMapping
    public HttpEntity<?> create(@RequestBody BookDto dto){
        Object o  = bookService.create(dto);
        return ResponseEntity.ok().body(o);
    }

    @GetMapping("/all")
    public HttpEntity<?> getAllBooks(){
        List<Book> allBooks = bookService.getAllBooks();

        return ResponseEntity.status(HttpStatus.FOUND).body(allBooks);
    }

    @GetMapping("/bookGenre/{id}")
    public HttpEntity<?> getBooksOfGenre(@PathVariable Integer id){

        List<Book> booksOfGenre = bookService.getBooksOfGenre(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(booksOfGenre);

    }
    @GetMapping("/{field}")
    public HttpEntity<?> getBooksOfGenre(@PathVariable String field){

        List<Book> sortedBooks = bookRepository.findAll(Sort.by(Sort.Direction.DESC,field));
        return ResponseEntity.status(HttpStatus.FOUND).body(sortedBooks);

    }
    @GetMapping("/pagination/{offset}/{pageSize}")
    public HttpEntity<?> getBooksbyPagination(@PathVariable int offset,@PathVariable int pageSize){
        Page<Book> allBooksByPagination = bookService.getAllBooksByPagination(offset, pageSize);
        return  ResponseEntity.status(HttpStatus.FOUND).body(allBooksByPagination);
    }
    @GetMapping("/pagination/{offset}/{pageSize}/{field}")
    public HttpEntity<?> getBooksbyPaginationAndSort(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field){
        Page<Book> allBooksByPagination = bookService.getAllBooksByPaginationAndSort(offset, pageSize,field);
        return  ResponseEntity.status(HttpStatus.FOUND).body(allBooksByPagination);
    }

    @PostMapping("/add")
    public  HttpEntity<?> addBook(@RequestBody BookDto bookDto){
        Book book = bookService.addBook(bookDto);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }


}
