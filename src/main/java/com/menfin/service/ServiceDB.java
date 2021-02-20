package com.menfin.service;

import com.menfin.Config;
import com.menfin.dao.objDao;
import com.menfin.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDB implements objDao<Book> {

    private final Connection connection;

    public ServiceDB(Config config) {
        this.connection = config.getConnection();
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        String sql = "SELECT id, author, name_book, rating FROM books";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Book book = new Book(
                        resultSet.getString("author"),
                        resultSet.getString("name_book"),
                        resultSet.getInt("rating")
                );
                bookList.add(book);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return bookList;
    }

    @Override
    public void saveBook(Book book) {
        String sql = "INSERT INTO books (author, name_book, rating) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            setEntity(book, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBook(Book book) {
        String sql = "UPDATE books SET author = ?, name_book = ?, rating = ? where author = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, book.getAuthor());
            preparedStatement.setString(2, book.getBookName());
            preparedStatement.setInt(3, book.getRating());
            preparedStatement.setString(4, book.getSearchAuthorBook());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBook(Book book) {
        String sql = "DELETE FROM books WHERE author = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, book.getAuthor());
            //        setEntity(book, preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Book getOneBook(Book searchBook) {
        ResultSet resultSet = null;
        Book book = new Book();
        String sql = "SELECT author, name_book, rating FROM books WHERE author = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, searchBook.getAuthor());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                book.setAuthor(resultSet.getString("author"));
                book.setBookName(resultSet.getString("name_book"));
                book.setRating(resultSet.getInt("rating"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Book> sortAuthorNameRating(final String stringSortName) {
        String sql = null;
        switch (stringSortName) {
            case "author":
                sql = "SELECT author, name_book, rating FROM books ORDER BY author";
                break;
            case "name":
                sql = "SELECT author, name_book, rating FROM books ORDER BY nameBook";
                break;
            case "rating":
                sql = "SELECT author, name_book, rating FROM books ORDER BY rating";
                break;
            default:
                throw new IllegalArgumentException(stringSortName);
        }
        List<Book> bookList = new ArrayList<>();
//        здесь пока не понятно как поступить - ? формирует выражение с '' , а это синтактическая ошибка
//        sql = "SELECT author, name_book, rating FROM books ORDER BY ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            preparedStatement.setString(1, stringSortName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book(
                        resultSet.getString("author"),
                        resultSet.getString("name_book"),
                        resultSet.getInt("rating")
                );
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;


    }

    private void setEntity(Book book, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, book.getAuthor());
        preparedStatement.setString(2, book.getBookName());
        preparedStatement.setInt(3, book.getRating());
    }
}

