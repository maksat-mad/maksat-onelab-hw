package com.onelab.spring.springtwo;

import com.onelab.spring.springtwo.config.JavaConfig;
import com.onelab.spring.springtwo.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class SpringTwoApplicationTests {

    @Test
    void test1() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext
                (JavaConfig.class);
        UserService service = ctx.getBean("userService", UserService.class);
        Assert.assertEquals("author_id = 1 author_name = Mark Twain\n" +
                "author_id = 2 author_name = Charles Dickens\n" +
                "author_id = 3 author_name = George Orwell\n" +
                "author_id = 4 author_name = Stephen King\n" +
                "author_id = 5 author_name = Joanne Rowling\n", service.getAllAuthors());
    }

    @Test
    void test2() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext
                (JavaConfig.class);
        UserService service = ctx.getBean("userService", UserService.class);
        Assert.assertEquals("genre_id = 1 genre_name = Adventure\n" +
                "genre_id = 2 genre_name = Classics\n" +
                "genre_id = 3 genre_name = Fantasy\n", service.getAllGenres());
    }

    @Test
    void test3() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext
                (JavaConfig.class);
        UserService service = ctx.getBean("userService", UserService.class);
        Assert.assertEquals("book_id = 1 title = Adventures of Tow Sawyer author_id = 1 genre_id = 1 price = 1000 amount = 50\n" +
                "book_id = 2 title = Adventures of Huckleberry Finn author_id = 1 genre_id = 1 price = 1000 amount = 30\n" +
                "book_id = 3 title = Oliver Twist author_id = 2 genre_id = 1 price = 1000 amount = 20\n" +
                "book_id = 4 title = 1984 author_id = 3 genre_id = 2 price = 1500 amount = 25\n" +
                "book_id = 5 title = Animal Farm author_id = 3 genre_id = 2 price = 1000 amount = 15\n" +
                "book_id = 6 title = Homage to Catalonia author_id = 3 genre_id = 2 price = 1500 amount = 10\n" +
                "book_id = 7 title = The Shining author_id = 4 genre_id = 3 price = 1500 amount = 15\n" +
                "book_id = 8 title = The Stand author_id = 4 genre_id = 3 price = 1500 amount = 20\n" +
                "book_id = 9 title = Misery author_id = 4 genre_id = 1 price = 2000 amount = 30\n" +
                "book_id = 10 title = Harry Potter and the Philosophers Stone author_id = 5 genre_id = 3 price = 2000 amount = 40\n" +
                "book_id = 11 title = Harry Potter and the Chamber of Secrets author_id = 5 genre_id = 3 price = 2000 amount = 35\n" +
                "book_id = 12 title = Harry Potter and the Prisoner of Azkaban author_id = 5 genre_id = 3 price = 2000 amount = 30\n" +
                "book_id = 13 title = Harry Potter and the Goblet of Fire author_id = 5 genre_id = 3 price = 2000 amount = 30\n" +
                "book_id = 14 title = Harry Potter and the Order of the Phoenix author_id = 5 genre_id = 3 price = 2000 amount = 30\n" +
                "book_id = 15 title = Harry Potter and the Half-Blood Prince author_id = 5 genre_id = 3 price = 2000 amount = 30\n" +
                "book_id = 16 title = Harry Potter and the Deathly Hallows author_id = 5 genre_id = 3 price = 2000 amount = 30\n", service.getAllBooks());
    }

}
