package com.onelab.task.controllers;

import com.onelab.task.patterns.singleton.SingletonService;
import com.onelab.task.entities.Author;
import com.onelab.task.entities.Book;
import com.onelab.task.entities.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    UserRestController(SingletonService singletonService) {
    }

    @GetMapping("/authors/{authorId}")
    public List<Author> findAuthorByAuthorId(@PathVariable("authorId") Long authorId) {
        return SingletonService.getUserService().findAuthorByAuthorId(authorId);
    }

    @GetMapping("/authors/{authorName}")
    public List<Author> findAuthorByAuthorName(@PathVariable("authorName") String authorName) {
        return SingletonService.getUserService().findAuthorByAuthorName(authorName);
    }

    @GetMapping("/authors")
    public List<Author> findAllAuthors() {
        return SingletonService.getUserService().findAllAuthors();
    }

    @GetMapping("/books")
    public List<Book> findAllBooks() {
        return SingletonService.getUserService().findAllBooks();
    }

    @GetMapping("/books/{bookId}")
    public List<Book> findBookByBookId(@PathVariable("bookId") Long bookId) {
        return SingletonService.getUserService().findBookByBookId(bookId);
    }

    @GetMapping("/books/title")
    public Set<String> findBookAllTitles() {
        return SingletonService.getUserService().findBookAllTitles();
    }

    @GetMapping("/books/magic/{title}")
    public String magicBookDecorator(@PathVariable("title") String title) {
        return SingletonService.getUserService().magicBookDecorator(title);
    }

    @GetMapping("/books/title/{title}")
    public List<Book> findBookByTitleEquals(@PathVariable("title") String title) {
        return SingletonService.getUserService().findBookByTitle(title);
    }

    @GetMapping("/books/price")
    public Set<Integer> findBookAllPrices() {
        return SingletonService.getUserService().findBookAllPrices();
    }

    @GetMapping("/books/price/{price}")
    public List<Book> findBookByPriceBeforeOrPriceEquals(@PathVariable("price") Integer price) {
        return SingletonService.getUserService().findBookByPriceBeforeOrPrice(price, price);
    }

    @GetMapping("/books/amount")
    public Set<Integer> findBookAllAmounts() {
        return SingletonService.getUserService().findBookAllAmounts();
    }

    @GetMapping("/books/amount/{amount}")
    public List<Book> findBookByAmountBeforeOrAmountEquals(@PathVariable("amount") Integer amount) {
        return SingletonService.getUserService().findBookByAmountBeforeOrAmount(amount, amount);
    }

    @GetMapping("/genres")
    public List<Genre> findAllGenres() {
        return SingletonService.getUserService().findAllGenres();
    }
}
