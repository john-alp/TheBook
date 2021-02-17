package com.menfin;

import java.util.List;

public interface Actions<T> {
    List<T> getAllBooks();
    void saveBook();
    void updateBook();
    void deleteBook();
    void sortBook();
    void filterBook();
}
