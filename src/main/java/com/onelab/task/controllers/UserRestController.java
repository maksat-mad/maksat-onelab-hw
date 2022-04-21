package com.onelab.task.controllers;

import com.onelab.task.design_pattern.singleton_pattern.SingletonService;
import com.onelab.task.entities.Author;
import com.onelab.task.entities.Book;
import com.onelab.task.entities.Genre;
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

    @Autowired
    UserRestController(SingletonService singletonService) {
    }

    // Get requests

    // Do not delete this
    /*@GetMapping("/authors/{name_author}")
    public List<Author> findAuthorByName_authorEquals(@PathVariable("name_author") String name_author) {
        return userService.findAuthorByName_authorEquals(name_author);
    }*/

    @GetMapping("/authors")
    public List<Author> findAllAuthors() {
        return SingletonService.getUserService().findAllAuthors();
    }

    @GetMapping("/books")
    public List<Book> findAllBooks() {
        return SingletonService.getUserService().findAllBooks();
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
                "/buy/{title}/{name_author}/{amount}   or   /buy/{title}/{name_author}\n" +
                "Good Luck! :)";
    }

    @GetMapping("/buy/{title}/{name_author}")
    public String buyBookByTitleAndNameAuthorAndAmount(@PathVariable("title") String title,
                                                       @PathVariable("name_author") String name_author) {
        return SingletonService.getUserService().buyBookByTitleAndNameAuthorAndAmount(title, name_author, 1);
    }

    @GetMapping("/buy/{title}/{name_author}/{amount}")
    public String buyBookByTitleAndNameAuthorAndAmount(@PathVariable("title") String title,
                                                       @PathVariable("name_author") String name_author,
                                                       @PathVariable("amount") Integer amount) {
        return SingletonService.getUserService().buyBookByTitleAndNameAuthorAndAmount(title, name_author, amount);
    }
}
