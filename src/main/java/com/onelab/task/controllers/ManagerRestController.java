package com.onelab.task.controllers;

import com.onelab.task.entities.UserRequestBook;
import com.onelab.task.patterns.singleton.SingletonService;
import com.onelab.task.entities.UserRequestTime;
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
//    @PostMapping("/author")
//    public String createAuthor(@RequestBody Author theAuthor) {
//
//        theAuthor.setAuthor_id(0L);
//
//        //logger.info(SingletonService.getManagerService().saveAuthor(theAuthor));
//
//        return SingletonService.getManagerService().saveAuthor(theAuthor);
//    }

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
