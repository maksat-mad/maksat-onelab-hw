package com.onelab.task.controllers;

import com.onelab.task.entities.*;
import com.onelab.task.patterns.singleton.SingletonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerRestController {

    private static final Logger logger = LoggerFactory.getLogger(ManagerRestController.class);

    @Autowired
    ManagerRestController(SingletonService singletonService) {
    }

    // Create
    @PostMapping(value = "/author")
    public String createAuthor(@RequestBody Author theAuthor) {

        theAuthor.setAuthorId(0L);

        return SingletonService.getManagerService().saveAuthor(theAuthor);
    }

    @PostMapping(value = "/book")
    public String createBook(@RequestBody Book theBook) {

        theBook.setBookId(0L);

        return SingletonService.getManagerService().saveBook(theBook);
    }

    @PostMapping(value = "/genre")
    public String createGenre(@RequestBody Genre theGenre) {

        theGenre.setGenreId(0L);

        return SingletonService.getManagerService().saveGenre(theGenre);
    }

    @DeleteMapping("/delete/author/{authorId}")
    public String deleteAuthorByAuthorId(@PathVariable("authorId") Long authorId) {
        return SingletonService.getManagerService().deleteAuthorByAuthorId(authorId);
    }

    @DeleteMapping("/delete/book/{bookId}")
    public String deleteAuthorByBookId(@PathVariable("bookId") Long bookId) {
        return SingletonService.getManagerService().deleteBookByBookId(bookId);
    }

    @DeleteMapping("/delete/genre/{genreId}")
    public String deleteAuthorByGenreId(@PathVariable("genreId") Long genreId) {
        return SingletonService.getManagerService().deleteGenreByGenreId(genreId);
    }

    @GetMapping("/analysis/time")
    public List<UserRequestTime> showTimes() {
        return SingletonService.getManagerService().showTimes();
    }

    @GetMapping("/analysis/books")
    public List<UserRequestBook> showRequestBooks() {
        return SingletonService.getManagerService().showRequestBooks();
    }
}
