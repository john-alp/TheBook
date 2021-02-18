package com.menfin.service;

import com.menfin.Config;
import com.menfin.dao.CRUD;
import com.menfin.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDB implements CRUD<Book> {
    private Connection connection;

    public ServiceDB(Config config) {
        this.connection = config.getConnection();
    }

    private void setEntity(Book book, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, book.getAuthor());
        preparedStatement.setString(2, book.getBookName());
        preparedStatement.setInt(3, book.getRating());
    }

    @Override
    public List getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        String sql = "SELECT id, author, book_name, rating FROM books";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Book book = new Book(
                        //resultSet.getInt("id"),
                        resultSet.getString("author"),
                        resultSet.getString("book_name"),
                        resultSet.getInt("rating")
                );
                bookList.add(book);
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return bookList;
    }

    @Override
    public void saveBook(Book book) {
        String sql = "INSERT INTO books (author, book_name, rating) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            setEntity(book, preparedStatement);
            if (preparedStatement.executeUpdate() != 1) {
                throw new IllegalArgumentException(Book.class.getName() + " Error: create new book");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public void deleteBook(Book book) {
        String sql = "DELETE FROM books WHERE author = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, book.getAuthor());
            //        setEntity(book, preparedStatement);
            if (preparedStatement.executeUpdate() != 1) {
                throw new IllegalArgumentException(Book.class.getName() + " Error: delete book");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Book getOneBook(Book searchBook) {
        ResultSet resultSet = null;
        Book book = new Book();
        String sql = "SELECT author, book_name, rating FROM books WHERE author = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, searchBook.getAuthor());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                book.setAuthor(resultSet.getString("author"));
                book.setBookName(resultSet.getString("book_name"));
                book.setRating(resultSet.getInt("rating"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }
}

