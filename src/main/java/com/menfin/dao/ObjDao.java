package com.menfin.dao;

import java.util.List;

public interface ObjDao<T> { // T Book

    List<T> getAllBooks();

    void saveBook(T book);

    void updateBook(T object);

    void deleteBook(T object);

    T getOneBook(T object);

    List<T> sortAuthorNameRating(String stringSortName);



}
