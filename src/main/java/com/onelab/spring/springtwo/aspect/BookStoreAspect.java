package com.onelab.spring.springtwo.aspect;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Aspect
@Component
public class BookStoreAspect {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:test", "sa", "");
    }

    private void closeConnection(Connection connection) {
        if (connection == null) {
            return;
        }
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Problem closing connection to the database!");
        }
    }

    @Before("execution(* com.onelab.spring.springtwo.service.UserService.getAllAuthors())")
    public void beforeGetAllAuthorsAdvice() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO author_log (time) " +
                            "VALUES (?)");
            statement.setString(1, dtf.format(now));
            statement.execute();
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Problem executing INSERT");
        } finally {
            closeConnection(connection);
        }

        System.out.println("\n=====>>> Executing @Before advice on getAllAuthors()");
        System.out.println("=====>>> Current time = " + dtf.format(now));
        System.out.println("=====>>> Current time is recorded to the database, table name is author_log");
    }

    @Before("execution(* com.onelab.spring.springtwo.service.UserService.getAllGenres())")
    public void beforeGetAllGenresAdvice() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO genre_log (time) " +
                            "VALUES (?)");
            statement.setString(1, dtf.format(now));
            statement.execute();
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Problem executing INSERT");
        } finally {
            closeConnection(connection);
        }

        System.out.println("\n=====>>> Executing @Before advice on getAllGenres()");
        System.out.println("=====>>> Current time = " + dtf.format(now));
        System.out.println("=====>>> Current time is recorded to the database, table name is genre_log");
    }

    @Before("execution(* com.onelab.spring.springtwo.service.UserService.getAllBooks())")
    public void beforeGetAllBooksAdvice() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO book_log (time) " +
                            "VALUES (?)");
            statement.setString(1, dtf.format(now));
            statement.execute();
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Problem executing INSERT");
        } finally {
            closeConnection(connection);
        }

        System.out.println("\n=====>>> Executing @Before advice on getAllBooks()");
        System.out.println("=====>>> Current time = " + dtf.format(now));
        System.out.println("=====>>> Current time is recorded to the database, table name is book_log");
    }
}
