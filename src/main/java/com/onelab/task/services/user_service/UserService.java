package com.onelab.task.services.user_service;

import com.onelab.task.design_pattern.singleton_pattern.SingletonRepository;
import com.onelab.task.entities.Author;
import com.onelab.task.entities.Book;
import com.onelab.task.entities.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class UserService {

    @Autowired
    public UserService(SingletonRepository singletonRepository) {
    }

    /**
    * This is UserService. Here user can:
    *
    * @Author Services
    * findAllAuthors +
     * findAuthorByAuthor_Id   *** DO THIS METHOD *******************
    * findAuthorByName_author  *** DO THIS METHOD *******************
    * findAuthorByBookTitle    *** DO THIS METHOD *******************
    *
    * @Book Services
    * findAllBooks +
    * findBookByBookId         *** DO THIS METHOD *******************
    * findBookAllTitles +
    * findBookByTitle +
    * findBookAllPrices +
    * findBookByPriceBeforeAndPriceEquals +
    * findBookAllAmounts +
    * findBookByAmountBeforeAndAmountEquals +
    * findAllGenres +
    * findBookByGenre_Name_genre    *** DO THIS METHOD **************
    * findBookByAuthor_Name_author  *** DO THIS METHOD **************
    *
    * @Buy Service
    * buyBookByTitleAndNameAuthorAndAmount +
    * buyBookByBookId               *** DO THIS METHOD **************
    * */

    // Author Services
    public List<Author> findAllAuthors() {
        return SingletonRepository.getAuthorRepository().findAll();
    }

    // Look this method does not work, I do not know why?
    /*public List<Author> findAuthorByName_authorEquals(String name_author) {
        return authorRepository.findAuthorByName_authorEquals(name_author);
    }*/

    // Book Services
    public List<Book> findAllBooks() {
        return SingletonRepository.getBookRepository().findAll();
    }

    public Set<String> findBookAllTitles() {
        return SingletonRepository.getBookRepository().findAll()
                .stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .map(Book::getTitle)
                .collect(Collectors.toSet());
    }

    public List<Book> findBookByTitleEquals(String title) {
        return SingletonRepository.getBookRepository().findBookByTitleEquals(title);
    }

    public Set<Integer> findBookAllPrices() {
        return SingletonRepository.getBookRepository().findAll()
                .stream()
                .sorted(Comparator.comparingInt(Book::getPrice))
                .map(Book::getPrice)
                .collect(Collectors.toSet());
    }

    public List<Book> findBookByPriceBeforeOrPriceEquals(Integer price_before, Integer price_equals) {
        return SingletonRepository.getBookRepository().findBookByPriceBeforeOrPriceEquals(price_before, price_equals);
    }

    public Set<Integer> findBookAllAmounts() {
        return SingletonRepository.getBookRepository().findAll()
                .stream()
                .sorted(Comparator.comparingInt(Book::getAmount))
                .map(Book::getAmount)
                .collect(Collectors.toSet());
    }

    public List<Book> findBookByAmountBeforeOrAmountEquals(Integer amount_before, Integer amount_equals) {
        return SingletonRepository.getBookRepository().findBookByAmountBeforeOrAmountEquals(amount_before, amount_equals);
    }

    // Genre Services
    public List<Genre> findAllGenres() {
        return SingletonRepository.getGenreRepository().findAll();
    }

    // Buy Service
    public String buyBookByTitleAndNameAuthorAndAmount(String title, String name_author, Integer amount) {
        List<Book> buy_book = SingletonRepository.getBookRepository().findBookByTitleEquals(title)
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
        buy_book.get(0).setAmount(buy_book.get(0).getAmount() - amount);
        if (buy_book.get(0).getAmount().equals(0)) {
            SingletonRepository.getBookRepository().delete(buy_book.get(0));
        } else {
            SingletonRepository.getBookRepository().save(buy_book.get(0));
        }
        return "THANK YOU :)\nYOU BOUGHT SUCCESSFULLY :)";
    }
}
