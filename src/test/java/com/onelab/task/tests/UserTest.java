package com.onelab.task.tests;

import com.onelab.task.entities.Author;
import com.onelab.task.entities.Book;
import com.onelab.task.entities.Genre;
import com.onelab.task.patterns.singleton.SingletonRepository;
import com.onelab.task.patterns.singleton.SingletonService;
import com.onelab.task.repository.AuthorRepository;
import com.onelab.task.repository.BookRepository;
import com.onelab.task.repository.GenreRepository;
import com.onelab.task.services.user.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserTest {

    @Mock
    AuthorRepository authorRepository;

    @Mock
    BookRepository bookRepository;

    @Mock
    GenreRepository genreRepository;

    @InjectMocks
    UserService userService;

    @InjectMocks
    SingletonRepository singletonRepository;

    @InjectMocks
    SingletonService singletonService;

    @Test
    void findAllAuthors() {
        List<Author> authors = userService.findAllAuthors();
        assertEquals(authors, authorRepository.findAll());
    }

    @Test
    void findAuthorByAuthorId() {
        List<Author> authors = userService.findAuthorByAuthorId(1L);
        assertEquals(authors, authorRepository.findAuthorByAuthorId(1L));
    }

    @Test
    void findAuthorByAuthorName() {
        List<Author> authors = userService.findAuthorByAuthorName("Mark Twain");
        assertEquals(authors, authorRepository.findAuthorByAuthorName("Mark Twain"));
    }

    @Test
    void findAllBooks() {
        List<Book> books = userService.findAllBooks();
        assertEquals(books, bookRepository.findAll());
    }

    @Test
    void findBookByBookId() {
        List<Book> books = userService.findBookByBookId(1L);
        assertEquals(books, bookRepository.findBookByBookId(1L));
    }

    @Test
    void findBookAllTitles() {
        Set<String> titles = userService.findBookAllTitles();
        assertFalse(titles.size() > 0);
    }

    @Test
    void findBookByTitleEquals() {
        List<Book> books = userService.findBookByTitleEquals("Adventures of Tow Sawyer");
        assertEquals(books, bookRepository.findBookByTitle("Adventures of Tow Sawyer"));
    }

    @Test
    void findBookAllPrices() {
        Set<Integer> prices = userService.findBookAllPrices();
        assertFalse(prices.size() > 0);
    }

    @Test
    void findBookByPriceBeforeOrPriceEquals() {
        List<Book> books = userService.findBookByPriceBeforeOrPriceEquals(1500, 1500);
        assertEquals(books, bookRepository.findBookByPriceBeforeOrPrice(1500, 1500));
    }

    @Test
    void findBookAllAmounts() {
        Set<Integer> amounts = userService.findBookAllAmounts();
        assertFalse(amounts.size() > 0);
    }

    @Test
    void findBookByAmountBeforeOrAmountEquals() {
        List<Book> books = userService.findBookByAmountBeforeOrAmountEquals(25, 25);
        assertEquals(books, bookRepository.findBookByAmountBeforeOrAmount(25, 25));
    }

    @Test
    void findAllGenres() {
        List<Genre> genres = userService.findAllGenres();
        assertEquals(genres, genreRepository.findAll());
    }
}