package com.onelab.task.design_pattern.singleton;

import com.onelab.task.repository.AuthorRepository;
import com.onelab.task.repository.BookRepository;
import com.onelab.task.repository.GenreRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class Singleton {

    private static AuthorRepository authorRepository;
    private static BookRepository bookRepository;
    private static GenreRepository genreRepository;

    @Autowired
    private Singleton(AuthorRepository authorRepository,
                      BookRepository bookRepository,
                      GenreRepository genreRepository) {
        Singleton.authorRepository = authorRepository;
        Singleton.bookRepository = bookRepository;
        Singleton.genreRepository = genreRepository;
    }

    public static AuthorRepository getAuthorRepository() {
        return authorRepository;
    }

    public static BookRepository getBookRepository() {
        return bookRepository;
    }

    public static GenreRepository getGenreRepository() {
        return genreRepository;
    }
}
