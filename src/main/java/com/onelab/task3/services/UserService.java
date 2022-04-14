package com.onelab.task3.services;

import com.onelab.task3.entities.AuthorEntity;
import com.onelab.task3.entities.BookEntity;
import com.onelab.task3.entities.GenreEntity;
import com.onelab.task3.repository.AuthorRepository;
import com.onelab.task3.repository.BookRepository;
import com.onelab.task3.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private GenreRepository genreRepository;

    @Autowired
    UserService(AuthorRepository authorRepository,
                BookRepository bookRepository,
                GenreRepository genreRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
    }

    public List<AuthorEntity> findAllAuthors() {
        return authorRepository.findAll();
    }

    public List<BookEntity> findAllBooks() {
        return bookRepository.findAll();
    }

    public List<GenreEntity> findAllGenres() {
        return genreRepository.findAll();
    }
}
