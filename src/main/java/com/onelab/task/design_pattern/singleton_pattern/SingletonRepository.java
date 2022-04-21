package com.onelab.task.design_pattern.singleton_pattern;

import com.onelab.task.repository.AuthorRepository;
import com.onelab.task.repository.BookRepository;
import com.onelab.task.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class SingletonRepository {

    private static AuthorRepository authorRepository;
    private static BookRepository bookRepository;
    private static GenreRepository genreRepository;

    @Autowired
    private SingletonRepository(AuthorRepository authorRepository,
                                BookRepository bookRepository,
                                GenreRepository genreRepository) {
        SingletonRepository.authorRepository = authorRepository;
        SingletonRepository.bookRepository = bookRepository;
        SingletonRepository.genreRepository = genreRepository;
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
