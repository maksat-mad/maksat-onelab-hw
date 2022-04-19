package com.onelab.spring.springtwo.config;

import com.onelab.spring.springtwo.aspect.BookStoreAspect;
import com.onelab.spring.springtwo.repository.AuthorRepository;
import com.onelab.spring.springtwo.repository.BookRepository;
import com.onelab.spring.springtwo.repository.GenreRepository;
import com.onelab.spring.springtwo.repository.impl.AuthorRepositoryImpl;
import com.onelab.spring.springtwo.repository.impl.BookRepositoryImpl;
import com.onelab.spring.springtwo.repository.impl.GenreRepositoryImpl;
import com.onelab.spring.springtwo.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
public class JavaConfig {
    @Bean
    public UserService userService() {
        return new UserService();
    }

    @Bean
    public AuthorRepository authorRepository() {return new AuthorRepositoryImpl();}

    @Bean
    public GenreRepository genreRepository() {return new GenreRepositoryImpl();}

    @Bean
    public BookRepository bookRepository() {return new BookRepositoryImpl();}

    @Bean
    public BookStoreAspect bookStoreAspect() {
        return new BookStoreAspect();
    }
}
