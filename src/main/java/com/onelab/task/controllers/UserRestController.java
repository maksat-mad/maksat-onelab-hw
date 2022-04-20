package com.onelab.task.controllers;

import com.onelab.task.entities.Author;
import com.onelab.task.entities.Book;
import com.onelab.task.entities.Genre;
import com.onelab.task.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserRestController {

    private final UserService userService;

    @Autowired
    UserRestController(UserService userService) {
        this.userService = userService;
    }

    // Get requests

    // Do not delete this
    /*@GetMapping("/authors/{name_author}")
    public List<Author> findAuthorByName_authorEquals(@PathVariable("name_author") String name_author) {
        return userService.findAuthorByName_authorEquals(name_author);
    }*/

    @GetMapping("/authors")
    public List<Author> findAllAuthors() {
        return userService.findAllAuthors();
    }

    @GetMapping("/books")
    public List<Book> findAllBooks() {
        return userService.findAllBooks();
    }

    @GetMapping("/books/title")
    public Set<String> findBookAllTitles() {
        return userService.findBookAllTitles();
    }

    @GetMapping("/books/title/{title}")
    public List<Book> findBookByTitleEquals(@PathVariable("title") String title) {
        return userService.findBookByTitleEquals(title);
    }

    @GetMapping("books/price")
    public Set<Integer> findBookAllPrices() {
        return userService.findBookAllPrices();
    }

    @GetMapping("books/price/{price}")
    public List<Book> findBookByPriceBeforeAndPriceEquals(@PathVariable Integer price) {
        return userService.findBookByPriceBeforeAndPriceEquals(price, price);
    }

    @GetMapping("books/amount")
    public Set<Integer> findBookAllAmounts() {
        return userService.findBookAllAmounts();
    }

    @GetMapping("books/amount/{amount}")
    public List<Book> findBookByAmountBeforeAndAmountEquals(@PathVariable Integer amount) {
        return userService.findBookByAmountBeforeAndAmountEquals(amount, amount);
    }

    @GetMapping("/genres")
    public List<Genre> findAllGenres() {
        return userService.findAllGenres();
    }
}
