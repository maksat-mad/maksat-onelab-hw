package com.onelab.task.services.user_service;

import com.onelab.task.entities.Author;
import com.onelab.task.entities.Book;
import com.onelab.task.entities.Genre;
import com.onelab.task.repository.AuthorRepository;
import com.onelab.task.repository.BookRepository;
import com.onelab.task.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class UserService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;

    @Autowired
    public UserService(AuthorRepository authorRepository,
                       BookRepository bookRepository,
                       GenreRepository genreRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
    }

    /*
    * This is UserService. Here user can:
    *
    * @Author Services
    * findAllAuthors +
    * findAuthorByName_author  *** DO THIS METHOD ***
    * findAuthorByBookTitle    *** DO THIS METHOD ***
    *
    * @Book Services
    * findAllBooks +
    * findBookByBookId         *** DO THIS METHOD ***
    * findBookAllTitles +
    * findBookByTitle +
    * findBookAllPrices +
    * findBookByPriceBeforeAndPriceEquals +
    * findBookAllAmounts +
    * findBookByAmountBeforeAndAmountEquals +
    * findAllGenres +
    * findBookByGenre_Name_genre    *** DO THIS METHOD ***
    * findBookByAuthor_Name_author  *** DO THIS METHOD ***
    *
    * @Buy Service
    * buyBookByTitleAndNameAuthorAndAmount +
    *
    * */

    // Author Services
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    // Look this method does not work, I do not know why?
    /*public List<Author> findAuthorByName_authorEquals(String name_author) {
        return authorRepository.findAuthorByName_authorEquals(name_author);
    }*/

    // Book Services
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Set<String> findBookAllTitles() {
        return bookRepository.findAll()
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toSet());
    }

    public List<Book> findBookByTitleEquals(String title) {
        return bookRepository.findBookByTitleEquals(title);
    }

    public Set<Integer> findBookAllPrices() {
        return bookRepository.findAll()
                .stream()
                .map(Book::getPrice)
                .collect(Collectors.toSet());
    }

    public List<Book> findBookByPriceBeforeOrPriceEquals(Integer price_before, Integer price_equals) {
        return bookRepository.findBookByPriceBeforeOrPriceEquals(price_before, price_equals);
    }

    public Set<Integer> findBookAllAmounts() {
        return bookRepository.findAll()
                .stream()
                .map(Book::getAmount)
                .collect(Collectors.toSet());
    }

    public List<Book> findBookByAmountBeforeOrAmountEquals(Integer amount_before, Integer amount_equals) {
        return bookRepository.findBookByAmountBeforeOrAmountEquals(amount_before, amount_equals);
    }

    // Genre Services
    public List<Genre> findAllGenres() {
        return genreRepository.findAll();
    }

    // Buy Service
    public String buyBookByTitleAndNameAuthorAndAmount(String title, String name_author, Integer amount) {
        List<Book> buy_book = bookRepository.findBookByTitleEquals(title)
                .stream()
                .filter(book -> book.getTitle().equals(title)
                        && book.getAuthor().getName_author().equals(name_author))
                .collect(toList());
        if (buy_book.size() == 0 || buy_book.get(0).getAmount() < amount) {
            if (amount.equals(1)) {
                return "Sorry :( \n We do not have such a book\nYOU CAN NOT BUY IT :(";
            }
            return "Sorry :( \n We do not have such amount of books\nYOU CAN NOT BUY THEM :(";
        }
        if (buy_book.get(0).getAmount().equals(amount)) {
            bookRepository.delete(buy_book.get(0));
        } else {
            buy_book.get(0).setAmount(buy_book.get(0).getAmount() - amount);
            bookRepository.save(buy_book.get(0));
        }
        return "THANK YOU :)\nYOU BOUGHT SUCCESSFULLY :)";
    }
}
