package com.onelab.task3.service_test;

import com.onelab.task3.entities.Author;
import com.onelab.task3.entities.Book;
import com.onelab.task3.entities.Genre;
import com.onelab.task3.repository.AuthorRepository;
import com.onelab.task3.repository.BookRepository;
import com.onelab.task3.repository.GenreRepository;
import com.onelab.task3.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    AuthorRepository authorRepository;

    @Mock
    BookRepository bookRepository;

    @Mock
    GenreRepository genreRepository;

    @InjectMocks
    UserService service;

    @Test
    void test1() {
        List<Author> authors = service.findAllAuthors();
        assertEquals(authors, authorRepository.findAll());
    }

    @Test
    void test2() {
        List<Book> books = service.findAllBooks();
        assertEquals(books, bookRepository.findAll());
    }

    @Test
    void test3() {
        List<Genre> genres = service.findAllGenres();
        assertEquals(genres, genreRepository.findAll());
    }
}
