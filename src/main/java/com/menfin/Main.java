package com.menfin;

import com.menfin.dao.ObjDao;
import com.menfin.entity.Book;
import com.menfin.service.ServiceDB;

public class Main {
    public static void main(String[] args) {
        ServiceDB serviceDB = new ServiceDB(new Config());
        ObjDao<Book> objDao = new ServiceDB(new Config());

        // CREATE ***************
//        Book book = new Book("Zbakumov", "ZLife today", 7);
//        Book book1 = new Book("Bumman", "Java 55", 2);

        // SAVE   ****************
//        serviceDB.saveBook(book);
//        serviceDB.saveBook(book1);

        //  UPDATE ****************
        // serviceDB.updateBook(new Book("Stanukovich", "See", 9, "org"));

        // DELETE by author *******
        //serviceDB.deleteBook(new Book("Stanukovich"));


        for (Book book : serviceDB.getAllBooks()) {

        }
        System.out.println("----------------------------------------------------------");

        for (Book book : objDao.getAllBooks() ) {
            System.out.println("for " + book);
        }

        //bookList.forEach((val) -> System.out.println(val));



        System.out.println("----------------------------------------------------------");
        for (Book sortBook : serviceDB.sortAuthorNameRating("author")) {
            System.out.println("sort " + sortBook);
        }
//        System.out.println("getOne " + serviceDB.getOneBook(new Book("John Silver")));

//        System.out.println("save" + serviceDB.getAllBooks());
//        System.out.println();

//        System.out.println("del " + serviceDB.getAllBooks());
//        System.out.println();
    }
}
