package com.menfin.service;

import com.menfin.Config;
import com.menfin.dao.ObjDao;
import com.menfin.entity.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ServiceDBTest {

    ServiceDB serviceDB = new ServiceDB(new Config());
    ObjDao<Book> objDao = new ServiceDB(new Config());
    Book standardBook = new Book("test", "testName", 5);
    Book standardUpdateAuthorBook = new Book("test", "testUpdate", 5, "test");

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
            if (standardBook.getBookName().equals(bookTest.getBookName())) {
                assertEquals(standardBook, bookTest);
                break;
            }
        }

        //bookList.forEach((val) -> System.out.println(val));
    }

    @Test
    public void saveBook() {
        serviceDB.saveBook(standardBook);
        assertEquals(standardBook, getStandardBookOfDB());
    }

    @Test
    public void updateBook() {
        serviceDB.saveBook(standardUpdateAuthorBook);
        assertEquals(standardUpdateAuthorBook, getStandartUpdateOneTestBookOfDB());
    }

    @Test
    public void deleteBook() {
        serviceDB.saveBook(standardBook);
        assertEquals(standardBook, getStandardBookOfDB());
        serviceDB.deleteBook(standardBook);
        assertNotEquals(standardBook, getStandardBookOfDB());
    }

    @Test
    public void getOneBook() {
        assertEquals(standardBook, getStandardBookOfDB());
    }

    @Test
    public void sortAuthorNameRating() {
    }

    private Book getStandardBookOfDB() {
        List<Book> bookList = serviceDB.getAllBooks();
        for (Book bookTest : bookList) {
            if (standardBook.getBookName().equals(bookTest.getBookName())) {
                return bookTest;
            }
        }

        return null;
    }

    private Book getStandartUpdateOneTestBookOfDB() {
        List<Book> bookList = serviceDB.getAllBooks();
        for (Book bookTest : bookList) {
            if (standardUpdateAuthorBook.getBookName().equals(bookTest.getBookName())) {
                return bookTest;
            }
        }
        return null;
    }
}