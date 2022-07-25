package com.example.booking.service;

import com.example.booking.entity.Book;
import com.example.booking.entity.BookGenre;
import com.example.booking.exceptionHandling.BookNotFoundException;
import com.example.booking.interfaces.GenericCrudService;
import com.example.booking.mappers.BookMapper;
import com.example.booking.payload.BookDto;
import com.example.booking.payload.BookGenreDto;
import com.example.booking.repository.BookGenreRepository;
import com.example.booking.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
//hehllol
import java.util.List;
import java.util.Optional;
//calll
@Service
@RequiredArgsConstructor
public class BookService implements GenericCrudService<Object,BookDto> {


    private final BookRepository bookRepository;
    private final BookGenreRepository bookGenreRepository;

    private final BookMapper mapper;
    @Override
    public Object create(BookDto dto) {
        Optional<Book> byTitle = bookRepository.findByTitle(dto.getTitle());
       if(byTitle.isPresent()){
           return new BookNotFoundException(dto.getTitle());
       }

       Book book = new Book();
        Optional<BookGenre> byId = bookGenreRepository.findById(dto.getBookGenreId());
        book.setBookGenre(byId.get());
        book.setAuthorName(dto.getAuthorName());
        book.setTitle(dto.getTitle());
        Book save = bookRepository.save(book);
        return save;
    }

    @Override
    public Book get() {
        return null;
    }

    @Override
    public Book update(Integer id) {
        return null;
    }

    @Override
    public void delete() {

    }
    public List<Book> getAllBooks(){
        List<Book> all = bookRepository.findAll();
        return all;
    }

    public List<Book> getBooksOfGenre(Integer bookGenreId){
        List<Book> allByBookGenreId = bookRepository.findAllByBookGenreId(bookGenreId);
        return allByBookGenreId;
    }
    public List<Book> searchBooksByTitle(String title){
        List<Book> byTitle = bookRepository.findAllByTitle(title);
        return byTitle;
    }
    public List<Book> searchBooksByAuthorName(String bookAuthorNameToSearch){
        List<Book> allByAuhtorName = bookRepository.findAllByAuthorNameIsContaining(bookAuthorNameToSearch);
        return allByAuhtorName;
    }


    public Book addBook(BookDto bookDto) {
        Book book = mapper.toBook(bookDto);
        Book save = bookRepository.save(book);
        return save;
//        Book book =new Book();
//        book.setTitle(bookDto.getTitle());
//        Optional<BookGenre> byId = bookGenreRepository.findById(bookDto.getBookGenreId());
//        book.setBookGenre(byId.get());
//        book.setAuthorName(bookDto.getAuthorName());
//        Book save = bookRepository.save(book);
//        return save;
    }

    public Page<Book> getAllBooksByPagination(int offset,int pageSize) {
        Page<Book> all = bookRepository.findAll(PageRequest.of(offset, pageSize));
        return  all;
    }
    public Page<Book> getAllBooksByPaginationAndSort(int offset,int pageSize,String field) {
        Page<Book> all = bookRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return  all;
    }
}
