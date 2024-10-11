package com.example.assignment3.dao;


import com.example.assignment3.model.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDao {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/students";
    private final String jdbcUsername = "amey";
    private final String jdbcPassword = "7507";

    private static final String INSERT_MOVIE_SQL = "INSERT INTO movies (title, genre, director, release_year) VALUES (?, ?, ?, ?);";
    private static final String SELECT_ALL_MOVIES = "SELECT * FROM movies;";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void addMovie(Movie movie) {
        System.out.println("addMovie Method called");
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MOVIE_SQL)) {
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setString(2, movie.getGenre());
            preparedStatement.setString(3, movie.getDirector());
            preparedStatement.setInt(4, movie.getReleaseYear());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MOVIES)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                String director = rs.getString("director");
                int releaseYear = rs.getInt("release_year");
                movies.add(new Movie(title, genre, director, releaseYear));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }
    private static final String SEARCH_MOVIES_BY_TITLE = "SELECT * FROM movies WHERE title LIKE ?;";
    private static final String SEARCH_MOVIES_BY_GENRE = "SELECT * FROM movies WHERE genre LIKE ?;";
    private static final String SEARCH_MOVIES_BY_DIRECTOR = "SELECT * FROM movies WHERE director LIKE ?;";

    public List<Movie> searchForMovies(String category, String searchTerm) {
        List<Movie> movies = new ArrayList<>();
        String query;

        // Determine the query based on the search category
        switch (category.toLowerCase()) {
            case "title":
                query = SEARCH_MOVIES_BY_TITLE;
                break;
            case "genre":
                query = SEARCH_MOVIES_BY_GENRE;
                break;
            case "director":
                query = SEARCH_MOVIES_BY_DIRECTOR;
                break;
            default:
                throw new IllegalArgumentException("Invalid search category: " + category);
        }

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, "%" + searchTerm + "%"); // Use LIKE operator for partial matches
            ResultSet rs = preparedStatement.executeQuery();

            // Process the result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                String director = rs.getString("director");
                int releaseYear = rs.getInt("release_year");

                // Create a new Movie object and add it to the list
                movies.add(new Movie(title, genre, director, releaseYear));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return movies;
    }

}
