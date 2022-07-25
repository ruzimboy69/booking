package com.example.booking.payload;

import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
//    @Column(nullable = false,unique = true)
    private String title;
    private String authorName;
    private Integer bookGenreId;
}
