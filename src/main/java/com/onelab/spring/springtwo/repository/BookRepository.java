package com.onelab.spring.springtwo.repository;

import com.onelab.spring.springtwo.dto.Book;

import java.util.List;

public interface BookRepository {
    public List<Book> getAllBooks();
}
