package com.menfin.entity;


public class Book {
    private String author;
    private String bookName;
    private int rating;
    private String searchAuthorBook;

    public Book() {
    }

    public Book(String author) {
        this.author = author;
    }

    public Book(String author, String bookName, int rating) {
        this.author = author;
        this.bookName = bookName;
        this.rating = rating;
    }

    public Book(String author, String bookName, int rating, String searchAuthorBook) {
        this.author = author;
        this.bookName = bookName;
        this.rating = rating;
        this.searchAuthorBook = searchAuthorBook;
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

    public String getSearchAuthorBook() {
        return searchAuthorBook;
    }

    public void setSearchAuthorBook(String searchAuthorBook) {
        this.searchAuthorBook = searchAuthorBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        return bookName != null ? bookName.equals(book.bookName) : book.bookName == null;
    }

    @Override
    public int hashCode() {
        int result = author != null ? author.hashCode() : 0;
        result = 31 * result + (bookName != null ? bookName.hashCode() : 0);
        return result;
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
