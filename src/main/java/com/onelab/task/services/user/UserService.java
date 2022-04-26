package com.onelab.task.services.user;

import com.onelab.task.entities.Author;
import com.onelab.task.entities.Book;
import com.onelab.task.entities.Genre;
import com.onelab.task.patterns.decorator.MyBook;
import com.onelab.task.patterns.decorator.decorators.*;
import com.onelab.task.patterns.singleton.SingletonRepository;
import com.onelab.task.patterns.strategy.TextEditor;
import com.onelab.task.patterns.strategy.TextFormatter;
import com.onelab.task.patterns.strategy.strategies.CapTextFormatter;
import com.onelab.task.patterns.strategy.strategies.LowerTextFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
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

        // Using strategy design pattern
        logAllTitlesCapStrategy();
        logAllTitlesLowerStrategy();

        return SingletonRepository.getBookRepository().findAll()
                .stream().map(Book::getTitle)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    private void logAllTitlesLowerStrategy() {
        TextFormatter formatter = new CapTextFormatter();
        TextEditor editor = new TextEditor(formatter);
        SingletonRepository.getBookRepository().findAll()
                .stream().map(Book::getTitle)
                .forEach(editor::logText);
    }

    private void logAllTitlesCapStrategy() {
        TextFormatter formatter = new LowerTextFormatter();
        TextEditor editor = new TextEditor(formatter);
        SingletonRepository.getBookRepository().findAll()
                .stream().map(Book::getTitle)
                .forEach(editor::logText);
    }

    public List<Book> findBookByTitle(String title) {
        return SingletonRepository.getBookRepository().findBookByTitle(title);
    }

    public Set<Integer> findBookAllPrices() {
        return SingletonRepository.getBookRepository().findAll()
                .stream().map(Book::getPrice)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public List<Book> findBookByPriceBeforeOrPrice(Integer price_before, Integer price_equals) {
        return SingletonRepository.getBookRepository().findBookByPriceBeforeOrPrice(price_before, price_equals);
    }

    public Set<Integer> findBookAllAmounts() {
        return SingletonRepository.getBookRepository().findAll()
                .stream().map(Book::getAmount)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public List<Book> findBookByAmountBeforeOrAmount(Integer amount_before, Integer amount_equals) {
        return SingletonRepository.getBookRepository().findBookByAmountBeforeOrAmount(amount_before, amount_equals);
    }

    // Genre Services
    public List<Genre> findAllGenres() {
        return SingletonRepository.getGenreRepository().findAll();
    }

    // for decorator design pattern
    public String magicBookDecorator(String title) {
        List<Book> book = SingletonRepository.getBookRepository().findBookByTitle(title);
        if (book.isEmpty()) {
            return "SORRY, we do not have that book :(";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("MAGIC BOOK DECORATOR decorating your book :)\n" + "YOUR book title: ")
                .append(title).append("\n")
                .append("author: ")
                .append(book.get(0).getAuthor().getAuthorName()).append("\n")
                .append("genre: ").append(book.get(0).getGenre().getGenreName()).append("\n")
                .append("price: ").append(book.get(0).getPrice()).append("\n");

        // Decorating myBook randomly
        Random rand = new Random();
        MyBook myBook;

        if (rand.nextInt(2) == 0) {
            myBook = new HardCoverBook();
        } else {
            myBook = new SoftCoverBook();
        }

        if (rand.nextInt(2) == 0) {
            myBook = new ArialFontDecorator(myBook);
        } else {
            myBook = new BigBookDecorator(myBook);
        }

        if (rand.nextInt(2) == 0) {
            myBook = new PicturesDecorator(myBook);
        } else {
            myBook = new YellowPageDecorator(myBook);
        }

        return sb.append(myBook.getDesc()).toString();
    }
}
