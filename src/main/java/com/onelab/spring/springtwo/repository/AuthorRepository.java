package com.onelab.spring.springtwo.repository;

import com.onelab.spring.springtwo.dto.Author;

import java.util.List;

public interface AuthorRepository {
    public List<Author> getAllAuthors();
}
