package com.example.booking.mappers.qualifier;


import com.example.booking.entity.BookGenre;
import com.example.booking.payload.BookDto;
import com.example.booking.payload.BookGenreDto;
import com.example.booking.repository.BookGenreRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Named("BookGenreQualifier")
public class BookGenreQualifier {

    private final BookGenreRepository bookGenreRepository;


    @Named("getBookGenre")
    public BookGenre getBookGenre(Integer bookGenreId) {
        Optional<BookGenre> byId = bookGenreRepository.findById(bookGenreId);
        return byId.get();
    }
}
