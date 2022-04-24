package com.onelab.task.tests;

import com.onelab.task.entities.Author;
import com.onelab.task.entities.Book;
import com.onelab.task.entities.Genre;
import com.onelab.task.patterns.singleton.SingletonRepository;
import com.onelab.task.patterns.singleton.SingletonService;
import com.onelab.task.repository.*;
import com.onelab.task.services.manager.ManagerService;
import com.onelab.task.services.user.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ManagerTest {

    @Mock
    AuthorRepository authorRepository;

    @Mock
    BookRepository bookRepository;

    @Mock
    GenreRepository genreRepository;

    @Mock
    UserRequestTimeRepository userRequestTimeRepository;

    @Mock
    UserRequestBookRepository userRequestBookRepository;

    @InjectMocks
    UserService userService;

    @InjectMocks
    ManagerService managerService;

    @InjectMocks
    SingletonRepository singletonRepository;

    @InjectMocks
    SingletonService singletonService;

    @Test
    void deleteAuthorByAuthorId() {
        String message = managerService.deleteAuthorByAuthorId(1L);
        assertEquals("SUCCESSFULLY DELETED the Author :)", message);
    }

    @Test
    void deleteBookByBookId() {
        String message = managerService.deleteBookByBookId(1L);
        assertEquals("SUCCESSFULLY DELETED the Book :)", message);
    }

    @Test
    void deleteGenreByGenreId() {
        String message = managerService.deleteGenreByGenreId(1L);
        assertEquals("SUCCESSFULLY DELETED the Genre :)", message);
    }

    @Test
    void saveAuthor() {
        Author author = new Author(9L, "Roma", new ArrayList<>());
        String message = managerService.saveAuthor(author);
        assertEquals("SUCCESSFULLY SAVED the Author :)", message);
    }

    @Test
    void saveBook() {
        Book book = new Book(9L, "My BOOK", 200, 100, null, null);
        String message = managerService.saveBook(book);
        assertEquals("SUCCESSFULLY SAVED the Book :)", message);
    }

    @Test
    void saveGenre() {
        Genre genre = new Genre(9L, "NEW GENRE",new ArrayList<>());
        String message = managerService.saveGenre(genre);
        assertEquals("SUCCESSFULLY SAVED the Genre :)", message);
    }

    @Test
    void showTimes() {
        try {
            managerService.showTimes();
        } catch (Exception ex) {
            fail();
        }
    }

    @Test
    void showRequestBooks() {
        try {
            managerService.showRequestBooks();
        } catch (Exception ex) {
            fail();
        }
    }
}