package com.menfin.service;

import com.menfin.dao.CRUD;

import java.sql.Connection;
import java.util.List;

public class serviceDB implements CRUD {
    private final Connection connection;

    public serviceDB(Config config) {
        this.config = connection;
    }

    @Override
    public List getAllBooks() {
           }

    @Override
    public void saveBook(Object object) {

    }

    @Override
    public void updateBook(Object object) {

    }

    @Override
    public void deleteBook(Object object) {

    }

    @Override
    public Object getOneBook(Object object) {
        return null;
    }
}
