package com.onelab.task.services;

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
        Set<String> res = new HashSet<>();
        List<Book> books = bookRepository.findAll();
        for (Book book : books) {
            res.add(book.getTitle());
        }
        return res;
    }

    public List<Book> findBookByTitleEquals(String title) {
        return bookRepository.findBookByTitleEquals(title);
    }

    public Set<Integer> findBookAllPrices() {
        Set<Integer> res = new HashSet<>();
        List<Book> books = bookRepository.findAll();
        for (Book book : books) {
            res.add(book.getPrice());
        }
        return res;
    }

    public List<Book> findBookByPriceBeforeAndPriceEquals(Integer price_before, Integer price_equals) {
        return bookRepository.findBookByPriceBeforeAndPriceEquals(price_before, price_equals);
    }

    public Set<Integer> findBookAllAmounts() {
        Set<Integer> res = new HashSet<>();
        List<Book> books = bookRepository.findAll();
        for (Book book : books) {
            res.add(book.getAmount());
        }
        return res;
    }

    public List<Book> findBookByAmountBeforeAndAmountEquals(Integer amount_before, Integer amount_equals) {
        return bookRepository.findBookByAmountBeforeAndAmountEquals(amount_before, amount_equals);
    }

    // Genre Services
    public List<Genre> findAllGenres() {
        return genreRepository.findAll();
    }
}
