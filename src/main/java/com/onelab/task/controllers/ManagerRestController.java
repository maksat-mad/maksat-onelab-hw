package com.onelab.task.controllers;

import com.onelab.task.entities.*;
import com.onelab.task.patterns.singleton.SingletonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerRestController {

    @Autowired
    ManagerRestController(SingletonService singletonService) {
    }

    // Create
    @PostMapping(value = "/create/author")
    @PreAuthorize("hasAuthority('author:write')")
    public String createAuthor(@RequestBody Author theAuthor) {

        theAuthor.setAuthorId(0L);

        return SingletonService.getManagerService().saveAuthor(theAuthor);
    }

    @PostMapping(value = "/create/book")
    @PreAuthorize("hasAuthority('book:write')")
    public String createBook(@RequestBody Book theBook) {

        theBook.setBookId(0L);

        return SingletonService.getManagerService().saveBook(theBook);
    }

    @PostMapping(value = "/create/genre")
    @PreAuthorize("hasAuthority('genre:write')")
    public String createGenre(@RequestBody Genre theGenre) {

        theGenre.setGenreId(0L);

        return SingletonService.getManagerService().saveGenre(theGenre);
    }

    // update
    @PutMapping(value = "/update/author")
    @PreAuthorize("hasAuthority('author:write')")
    public String updateAuthor(@RequestBody Author theAuthor) {
        return SingletonService.getManagerService().saveAuthor(theAuthor);
    }

    @PutMapping(value = "/update/book")
    @PreAuthorize("hasAuthority('book:write')")
    public String updateBook(@RequestBody Book theBook) {
        return SingletonService.getManagerService().saveBook(theBook);
    }

    @PutMapping(value = "/update/genre")
    @PreAuthorize("hasAuthority('genre:write')")
    public String updateGenre(@RequestBody Genre theGenre) {
        return SingletonService.getManagerService().saveGenre(theGenre);
    }

    // delete
    @DeleteMapping("/delete/author/{authorId}")
    @PreAuthorize("hasAuthority('author:write')")
    public String deleteAuthorByAuthorId(@PathVariable("authorId") Long authorId) {
        return SingletonService.getManagerService().deleteAuthorByAuthorId(authorId);
    }

    @DeleteMapping("/delete/book/{bookId}")
    @PreAuthorize("hasAuthority('book:write')")
    public String deleteAuthorByBookId(@PathVariable("bookId") Long bookId) {
        return SingletonService.getManagerService().deleteBookByBookId(bookId);
    }

    @DeleteMapping("/delete/genre/{genreId}")
    @PreAuthorize("hasAuthority('genre:write')")
    public String deleteAuthorByGenreId(@PathVariable("genreId") Long genreId) {
        return SingletonService.getManagerService().deleteGenreByGenreId(genreId);
    }

    // collected data for data analysis
    @GetMapping("/analysis/time")
    @PreAuthorize("hasAuthority('analysis')")
    public List<UserRequestTime> showTimes() {
        return SingletonService.getManagerService().showTimes();
    }

    @GetMapping("/analysis/books")
    @PreAuthorize("hasAuthority('analysis')")
    public List<UserRequestBook> showRequestBooks() {
        return SingletonService.getManagerService().showRequestBooks();
    }
}
