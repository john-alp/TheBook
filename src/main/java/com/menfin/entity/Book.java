package com.menfin.entity;

import com.menfin.Actions;

import java.util.ArrayList;
import java.util.List;

public class Book implements Actions {

    private List<Book> bookList = new ArrayList<>();

    @Override
    public List<Book> getBook() {
        return bookList;
    }

    @Override
    public void saveBook() {

    }

    @Override
    public void updateBook() {

    }

    @Override
    public void deleteBook() {

    }

    @Override
    public void sortBook() {

    }

    @Override
    public void filterBook() {


    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
