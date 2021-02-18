package com.menfin.entity;


public class Book {
    private String author;
    private String bookName;
    private int rating;

    public Book() {}
    public Book(String author) {
        this.author = author;
    }
    public Book(String author, String bookName, int rating) {
        this.author = author;
        this.bookName = bookName;
        this.rating = rating;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", bookName='" + bookName + '\'' +
                ", rating=" + rating +
                '}';
    }
}
