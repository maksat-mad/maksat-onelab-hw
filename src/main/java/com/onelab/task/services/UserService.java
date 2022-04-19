package com.onelab.task.services;

import com.onelab.task.entities.Author;
import com.onelab.task.entities.Book;
import com.onelab.task.entities.Genre;
import com.onelab.task.kafka.KafkaProducers;
import com.onelab.task.repository.AuthorRepository;
import com.onelab.task.repository.BookRepository;
import com.onelab.task.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;

    private final KafkaProducers kafkaProducers;

    @Autowired
    public UserService(AuthorRepository authorRepository,
                       BookRepository bookRepository,
                       GenreRepository genreRepository,
                       KafkaProducers kafkaProducers) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
        this.kafkaProducers = kafkaProducers;
    }

    public List<Author> findAllAuthors() {
        kafkaProducers.sendMessage("User is finding all Authors");
        LocalDateTime now = LocalDateTime.now();
        kafkaProducers.sendTime(now);
        return authorRepository.findAll();
    }

    public List<Book> findAllBooks() {
        kafkaProducers.sendMessage("User is finding all Books");
        LocalDateTime now = LocalDateTime.now();
        kafkaProducers.sendTime(now);
        return bookRepository.findAll();
    }

    public List<Genre> findAllGenres() {
        kafkaProducers.sendMessage("User is finding all Genres");
        LocalDateTime now = LocalDateTime.now();
        kafkaProducers.sendTime(now);
        return genreRepository.findAll();
    }
}
