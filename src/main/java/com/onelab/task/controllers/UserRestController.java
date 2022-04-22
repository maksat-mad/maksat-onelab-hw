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

    // Get requests

    // Do not delete this
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

    @GetMapping("/books/title/{title}")
    public List<Book> findBookByTitleEquals(@PathVariable("title") String title) {
        return SingletonService.getUserService().findBookByTitleEquals(title);
    }

    @GetMapping("/books/price")
    public Set<Integer> findBookAllPrices() {
        return SingletonService.getUserService().findBookAllPrices();
    }

    @GetMapping("/books/price/{price}")
    public List<Book> findBookByPriceBeforeOrPriceEquals(@PathVariable("price") Integer price) {
        return SingletonService.getUserService().findBookByPriceBeforeOrPriceEquals(price, price);
    }

    @GetMapping("/books/amount")
    public Set<Integer> findBookAllAmounts() {
        return SingletonService.getUserService().findBookAllAmounts();
    }

    @GetMapping("/books/amount/{amount}")
    public List<Book> findBookByAmountBeforeOrAmountEquals(@PathVariable("amount") Integer amount) {
        return SingletonService.getUserService().findBookByAmountBeforeOrAmountEquals(amount, amount);
    }

    @GetMapping("/genres")
    public List<Genre> findAllGenres() {
        return SingletonService.getUserService().findAllGenres();
    }

    @GetMapping("/buy")
    public String buyInfo() {
        return "INSTRUCTIONS, ATTENTION PLEASE !!!\n" +
                "Hello user, you can buy a book or books buy entering this\n" +
                "/buy/{title}/{authorName}/{amount}   or   /buy/{title}/{authorName} " +
                "    or     /buy/{bookId}      or       /buy/{bookId}/{amount}\n" +
                "Good Luck! :)";
    }

    @PutMapping("/buy/{bookId}")
    public String buyBookByBookId(@PathVariable("bookId") Long bookId) {
        return SingletonService.getUserService().buyBookByIdAndAmount(bookId, 1);
    }

    @PutMapping("/buy/{bookId}/{amount}")
    public String buyBookByBookId(@PathVariable("bookId") Long bookId,
                                  @PathVariable("amount") Integer amount) {
        return SingletonService.getUserService().buyBookByIdAndAmount(bookId, amount);
    }

    @PutMapping("/buy/{title}/{authorName}")
    public String buyBookByTitleAndNameAuthorAndAmount(@PathVariable("title") String title,
                                                       @PathVariable("authorName") String authorName) {
        return SingletonService.getUserService().buyBookByTitleAndNameAuthorAndAmount(title, authorName, 1);
    }

    @PutMapping("/buy/{title}/{authorName}/{amount}")
    public String buyBookByTitleAndNameAuthorAndAmount(@PathVariable("title") String title,
                                                       @PathVariable("authorName") String authorName,
                                                       @PathVariable("amount") Integer amount) {
        return SingletonService.getUserService().buyBookByTitleAndNameAuthorAndAmount(title, authorName, amount);
    }
}
