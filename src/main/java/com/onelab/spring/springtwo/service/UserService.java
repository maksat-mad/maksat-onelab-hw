package com.onelab.spring.springtwo.service;

import com.onelab.spring.springtwo.dto.Author;
import com.onelab.spring.springtwo.dto.Book;
import com.onelab.spring.springtwo.dto.Genre;
import com.onelab.spring.springtwo.repository.AuthorRepository;
import com.onelab.spring.springtwo.repository.BookRepository;
import com.onelab.spring.springtwo.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    GenreRepository genreRepository;

    @Autowired
    BookRepository bookRepository;

    public String getAllAuthors() {
        List<Author> authors = authorRepository.getAllAuthors();
        StringBuilder sb = new StringBuilder();
        for (Author author : authors) {
            sb.append("author_id = " + author.getAuthor_id() + " author_name = " + author.getAuthor_name() + "\n");
        }
        return sb.toString();
    }

    public String getAllGenres() {
        List<Genre> genres = genreRepository.getAllGenres();
        StringBuilder sb = new StringBuilder();
        for (Genre genre : genres) {
            sb.append("genre_id = " + genre.getGenre_id() + " genre_name = " + genre.getName_genre() + "\n");
        }
        return sb.toString();
    }

    public String getAllBooks() {
        List<Book> books = bookRepository.getAllBooks();
        StringBuilder sb = new StringBuilder();
        for (Book book : books) {
            sb.append("book_id = " + book.getBook_id() + " title = " + book.getTitle() +
                    " author_id = " + book.getAuthor_id() + " genre_id = " + book.getGenre_id() +
                    " price = " + book.getPrice() + " amount = " + book.getAmount() + "\n");
        }
        return sb.toString();
    }
}
