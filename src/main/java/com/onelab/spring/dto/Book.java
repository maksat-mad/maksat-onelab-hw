package com.onelab.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int book_id;
    private String title;
    private int author_id;
    private int genre_id;
    private int price;
    private int amount;
}
