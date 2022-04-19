package com.onelab.spring.springtwo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private long book_id;
    private String title;
    private long author_id;
    private long genre_id;
    private int price;
    private int amount;
}
