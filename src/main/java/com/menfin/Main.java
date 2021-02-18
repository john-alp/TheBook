package com.menfin;

import com.menfin.entity.Book;
import com.menfin.service.ServiceDB;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ServiceDB serviceDB = new ServiceDB(new Config());
        Book book = new Book("Saturn", "rings", 3);

        // save
        //  serviceDB.saveBook(book);
        // all

        for (Object books : serviceDB.getAllBooks()) {
            System.out.println("for" + books);
        }

        System.out.println("getOne " + serviceDB.getOneBook(new Book("Saturn")));

//        System.out.println("save" + serviceDB.getAllBooks());
//        System.out.println();
        // delete by author
//        serviceDB.deleteBook(new Book("Remark"));
//        System.out.println("del " + serviceDB.getAllBooks());
//        System.out.println();
    }
}
