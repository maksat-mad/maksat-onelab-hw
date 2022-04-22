package com.onelab.task.patterns.singleton;

import com.onelab.task.repository.AuthorRepository;
import com.onelab.task.repository.BookRepository;
import com.onelab.task.repository.GenreRepository;
import com.onelab.task.repository.UserRequestTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class SingletonRepository {

    private static AuthorRepository authorRepository;
    private static BookRepository bookRepository;
    private static GenreRepository genreRepository;
    private static UserRequestTimeRepository userRequestTimeRepository;

    @Autowired
    private SingletonRepository(AuthorRepository authorRepository,
                                BookRepository bookRepository,
                                GenreRepository genreRepository,
                                UserRequestTimeRepository userRequestTimeRepository) {
        SingletonRepository.authorRepository = authorRepository;
        SingletonRepository.bookRepository = bookRepository;
        SingletonRepository.genreRepository = genreRepository;
        SingletonRepository.userRequestTimeRepository = userRequestTimeRepository;
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

    public static UserRequestTimeRepository getUserRequestTimeRepository() {
        return userRequestTimeRepository;
    }
}
