package com.onelab.task.services.manager_service;

import com.onelab.task.repository.AuthorRepository;
import com.onelab.task.repository.BookRepository;
import com.onelab.task.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;

    @Autowired
    public ManagerService(AuthorRepository authorRepository,
                       BookRepository bookRepository,
                       GenreRepository genreRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
    }

    /**
     * @Author Service
     * createAuthor
     *
     * deleteAuthor
     *
     * deleteAllAuthors
     *
     * updateAuthors
     * updateAuthorByName
     * updateAuthorById
     *
     * @Book
     * createBook
     *
     * deleteBook
     *
     * deleteAllBooks
     *
     * updateBooks
     * updateBookByName
     * updateBookById
     *
     * @Genre
     * createGenre
     *
     * deleteGenre
     *
     * deleteAllGenres
     *
     * updateGenreByName
     * updateGenreById
     *
     *
     * */

    // Author Service

}
