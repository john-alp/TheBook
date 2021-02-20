package com.menfin.service;

import com.menfin.Config;
import com.menfin.entity.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.List;

import static org.junit.Assert.*;

public class ServiceDBTest {
    //    private final Connection connection;
//
//    public ServiceDB(Config config) {
//        this.connection = config.getConnection();
//    }
    Config config = new Config();
    ServiceDB serviceDB = new ServiceDB(config);
    Connection connection = config.getConnection();
    Book standartBook = new Book("test", "testName", 5);
    Book standartBookUpdateAuthor = new Book("testUpdate", "testName", 5, "test");

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAllBooks() {
        List<Book> bookList = serviceDB.getAllBooks();
        for (Book bookTest : bookList) {
            if (bookTest.getBookName().equals(standartBook.getBookName())) {
                assertEquals(standartBook, bookTest);
                break;
            }
        }

        //bookList.forEach((val) -> System.out.println(val));
    }

    @Test
    public void saveBook() {
        ServiceDB serviceDB = new ServiceDB(config);
        serviceDB.saveBook(standartBook);
        assertEquals(standartBook, getOneTestBookOfDB());
    }

    @Test
    public void updateBook() {
        serviceDB.saveBook(standartBookUpdateAuthor);
        assertEquals(standartBookUpdateAuthor, getUpdateOneTestBookOfDB());

    }

    @Test
    public void deleteBook() {
        serviceDB.saveBook(standartBook);
        assertEquals(standartBook, getOneTestBookOfDB());
        serviceDB.deleteBook(standartBook);
        assertNotEquals(standartBook, getOneTestBookOfDB());
    }

    @Test
    public void getOneBook() {
        assertEquals(standartBook, getOneTestBookOfDB());
    }

    @Test
    public void sortAuthorNameRating() {
    }

    private void setEntity(Book book, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, book.getAuthor());
        preparedStatement.setString(2, book.getBookName());
        preparedStatement.setInt(3, book.getRating());
    }

    private Book getOneTestBookOfDB() {
        ServiceDB serviceDB = new ServiceDB(config);
        List<Book> bookList = serviceDB.getAllBooks();
        for (Book bookTest : bookList) {
            if (standartBook.getBookName().equals(bookTest.getBookName())) {
                return bookTest;
            }
        }
        return null;
    }

    private Book getUpdateOneTestBookOfDB() {
        ServiceDB serviceDB = new ServiceDB(config);
        List<Book> bookList = serviceDB.getAllBooks();
        for (Book bookTest : bookList) {
            if (standartBookUpdateAuthor.getAuthor().equals(bookTest.getAuthor())) {
                return bookTest;
            }
        }
        return null;
    }
}