package com.onelab.task3.services;

import com.onelab.task3.entities.Author;
import com.onelab.task3.entities.Book;
import com.onelab.task3.entities.Genre;
import com.onelab.task3.repository.AuthorRepository;
import com.onelab.task3.repository.BookRepository;
import com.onelab.task3.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;

    @Autowired
    public UserService(AuthorRepository authorRepository,
                       BookRepository bookRepository,
                       GenreRepository genreRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
    }

    /*public UserService() {

    }*/

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public List<Genre> findAllGenres() {
        return genreRepository.findAll();
    }

    /*public Author findAuthorByNameOfAuthor(String nameAuthor) {
        return authorRepository.findAuthorByName_author(nameAuthor);
    }*/
}
