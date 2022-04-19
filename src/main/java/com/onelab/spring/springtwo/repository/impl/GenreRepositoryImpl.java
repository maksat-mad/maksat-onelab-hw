package com.onelab.spring.springtwo.repository.impl;

import com.onelab.spring.springtwo.dto.Genre;
import com.onelab.spring.springtwo.repository.GenreRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GenreRepositoryImpl implements GenreRepository {
    List<Genre> genres;

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
    public List<Genre> getAllGenres() {
        this.genres = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement =
                    connection.prepareStatement("SELECT * FROM genre");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Genre genre = new Genre();
                genre.setGenre_id(resultSet.getLong("genre_id"));
                genre.setName_genre(resultSet.getString("name_genre"));
                genres.add(genre);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Problem when executing SELECT!");
        } finally {
            closeConnection(connection);
        }
        return genres;
    }
}
