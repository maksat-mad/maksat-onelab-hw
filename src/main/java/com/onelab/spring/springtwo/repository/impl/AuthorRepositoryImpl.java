package com.onelab.spring.springtwo.repository.impl;

import com.onelab.spring.springtwo.dto.Author;
import com.onelab.spring.springtwo.repository.AuthorRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {
    List<Author> authors;

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
    public List<Author> getAllAuthors() {
        this.authors = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement =
                    connection.prepareStatement("SELECT * FROM author");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Author author = new Author();
                author.setAuthor_id(resultSet.getLong("author_id"));
                author.setAuthor_name(resultSet.getString("name_author"));
                authors.add(author);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Problem when executing SELECT!");
        } finally {
            closeConnection(connection);
        }
        return authors;
    }
}
