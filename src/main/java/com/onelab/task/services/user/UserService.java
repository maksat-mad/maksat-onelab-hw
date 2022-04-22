package com.onelab.task.services.user;

import com.onelab.task.patterns.singleton.SingletonRepository;
import com.onelab.task.entities.Author;
import com.onelab.task.entities.Book;
import com.onelab.task.entities.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
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
     * findAuthorByAuthorId   +
    * findAuthorByAuthorName  +
    *
    * @Book Services
    * findAllBooks +
    * findBookByBookId +
    * findBookAllTitles +
    * findBookByTitle +
    * findBookAllPrices +
    * findBookByPriceBeforeAndPrice +
    * findBookAllAmounts +
    * findBookByAmountBeforeAndAmount +
    * findAllGenres +
    *
    * @Buy Service
    * buyBookByTitleAndNameAuthorAndAmount +
    * buyBookByBookId +
    * */

    // Author Services
    public List<Author> findAllAuthors() {
        return SingletonRepository.getAuthorRepository().findAll();
    }

    public List<Author> findAuthorByAuthorId(Long authorId) {
        return SingletonRepository.getAuthorRepository().findAuthorByAuthorId(authorId);
    }

    public List<Author> findAuthorByAuthorName(String authorName) {
        return SingletonRepository.getAuthorRepository().findAuthorByAuthorName(authorName);
    }

    // Book Services
    public List<Book> findAllBooks() {
        return SingletonRepository.getBookRepository().findAll();
    }

    public List<Book> findBookByBookId(Long bookId) {
        return SingletonRepository.getBookRepository().findBookByBookId(bookId);
    }

    public Set<String> findBookAllTitles() {
        return SingletonRepository.getBookRepository().findAll()
                .stream().map(Book::getTitle)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public List<Book> findBookByTitleEquals(String title) {
        return SingletonRepository.getBookRepository().findBookByTitle(title);
    }

    public Set<Integer> findBookAllPrices() {
        return SingletonRepository.getBookRepository().findAll()
                .stream().map(Book::getPrice)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public List<Book> findBookByPriceBeforeOrPriceEquals(Integer price_before, Integer price_equals) {
        return SingletonRepository.getBookRepository().findBookByPriceBeforeOrPrice(price_before, price_equals);
    }

    public Set<Integer> findBookAllAmounts() {
        return SingletonRepository.getBookRepository().findAll()
                .stream().map(Book::getAmount)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public List<Book> findBookByAmountBeforeOrAmountEquals(Integer amount_before, Integer amount_equals) {
        return SingletonRepository.getBookRepository().findBookByAmountBeforeOrAmount(amount_before, amount_equals);
    }

    // Genre Services
    public List<Genre> findAllGenres() {
        return SingletonRepository.getGenreRepository().findAll();
    }

    // Buy Service

    public String buyBookByIdAndAmount(Long bookId, Integer amount) {
        if (amount <= 0) {
            return "Give us valid book amount :(";
        }
        List<Book> buyBook = SingletonRepository.getBookRepository().findBookByBookId(bookId);
        return buyThisBook(amount, buyBook);
    }

    private String buyThisBook(Integer amount, List<Book> buyBook) {
        if (buyBook.size() == 0 || buyBook.get(0).getAmount() < amount
                || buyBook.get(0).getAmount() == 0) {
            return "Sorry :( \n We do not have such book\nYOU CAN NOT BUY IT :(";
        }
        buyBook.get(0).setAmount(buyBook.get(0).getAmount() - amount);
        if (buyBook.get(0).getAmount() == 0) {
            SingletonRepository.getBookRepository().deleteBookByBookId(buyBook.get(0).getBookId());
        } else {
            SingletonRepository.getBookRepository().save(buyBook.get(0));
        }
        return "THANK YOU :)\nYOU BOUGHT SUCCESSFULLY :)";
    }

    public String buyBookByTitleAndNameAuthorAndAmount(String title, String authorName, Integer amount) {
        if (amount <= 0) {
            return "Give us valid book amount :(";
        }
        List<Book> buyBook = SingletonRepository.getBookRepository().findBookByTitle(title)
                .stream()
                .filter(book -> book.getTitle().equals(title)
                        && book.getAuthor().getAuthorName().equals(authorName))
                .collect(toList());
        return buyThisBook(amount, buyBook);
    }
}
