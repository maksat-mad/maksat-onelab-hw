package com.onelab.task.services.user;

import com.onelab.task.entities.Author;
import com.onelab.task.entities.Book;
import com.onelab.task.entities.Genre;
import com.onelab.task.patterns.singleton.SingletonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    public UserService(SingletonRepository singletonRepository) {
    }

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
}
