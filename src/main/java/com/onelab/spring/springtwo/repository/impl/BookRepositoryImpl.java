package com.onelab.spring.springtwo.repository.impl;

import com.onelab.spring.springtwo.dto.Book;
import com.onelab.spring.springtwo.dto.Genre;
import com.onelab.spring.springtwo.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {
    List<Book> books;

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

    @Override
    public List<Book> getAllBooks() {
        this.books = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement =
                    connection.prepareStatement("SELECT * FROM book");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setBook_id(resultSet.getLong("book_id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor_id(resultSet.getLong("author_id"));
                book.setGenre_id(resultSet.getLong("genre_id"));
                book.setPrice(resultSet.getInt("price"));
                book.setAmount(resultSet.getInt("amount"));
                books.add(book);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Problem when executing SELECT!");
        } finally {
            closeConnection(connection);
        }
        return books;
    }
}
