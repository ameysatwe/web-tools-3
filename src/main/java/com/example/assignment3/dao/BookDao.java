package com.example.assignment3.dao;
import com.example.assignment3.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/students";
    private final String jdbcUsername = "amey";
    private final String jdbcPassword = "7507";

    private static final String INSERT_MOVIE_SQL = "INSERT INTO books (isbn,title,authors,price) VALUES (?, ?, ?, ?);";
    private static final String SELECT_ALL_MOVIES = "SELECT * FROM books;";

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

    public void addBook(Book book) {
        System.out.println("addMovie Method called");
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MOVIE_SQL)) {
            preparedStatement.setString(1,  book.getTitle());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getAuthors());
            preparedStatement.setFloat(4, book.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MOVIES)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("isbn");
                String genre = rs.getString("title");
                String director = rs.getString("authors");
                float price = rs.getInt("price");
                books.add(new Book(title, genre, director, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

}
