package com.example.booking.mappers;


import com.example.booking.entity.Book;
import com.example.booking.entity.BookGenre;
import com.example.booking.mappers.qualifier.BookGenreQualifier;
import com.example.booking.payload.BookDto;
import com.example.booking.repository.BookGenreRepository;
import com.example.booking.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Optional;


@Mapper(componentModel = "spring", uses = {BookMapper.class,BookGenreQualifier.class    })
//@RequiredArgsConstructor
public interface BookMapper {
//    final BookRepository bookRepository;
//    final BookGenreRepository bookGenreRepository;

    @Mapping(source = "bookGenreId", target = "bookGenre" ,qualifiedByName = "getBookGenre")
    @Mapping(source = "authorName", target = "authorName")
    Book toBook(BookDto bookDt);

//
//    @Named("bookQualifier")
//    public String getBookGenre(BookDto bookDto){
//        Optional<BookGenre> byId = bookGenreRepository.findById(bookDto.getBookGenreId());
//        return byId.get().getGenre()+byId.get().getId();
//    }

}
