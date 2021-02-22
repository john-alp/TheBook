
package com.menfin.mvc;


import com.menfin.Config;
import com.menfin.entity.Book;
import com.menfin.service.ServiceDB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Friend {
    private final int MINSIZE = 2;
    private final int MAXSIZE = 30;
    private final int MINSALARY = 0;
    private final int MAXSALARY = 9;
    private final String PATTERNFORPHONE = "\\d{3}-\\d{3}-\\d{2}-\\d{2}";
//    @Size(min = MINSIZE, max = MAXSIZE, message = " Sorry, name must be min " + MINSIZE
//            + " symbols, max " + MAXSIZE + " symbols")
    private String author;
    // @NotNull()
    // @NotEmpty()

//    @NotBlank(message = "Sorry, surname is required field")
    private String bookName;

//    @Min(value = MINSALARY, message = "must be greater than " + MINSALARY)
//    @Max(value = MAXSALARY, message = "must be greater than " + MAXSALARY)
    private int rating;
    private String department;
    private Map<String, String> departments;
    private String carBrand;
    private Map<String, String> carBrands;
    private String[] languages;
    private List<Book> bookList = new ArrayList<>();
    private Map<String, String> languageList;

//    @Pattern(regexp = PATTERNFORPHONE, message = "Please use pattern XXX-XXX-XX-XX")
    private String phoneNumber;

    public Friend() {
       bookList = new ServiceDB(new Config()).getAllBooks();


        if (departments == null) {
            departments = new HashMap<>();


            departments.put("Information Technology", "IT");
            departments.put("Human Resources", "HR");
            departments.put("Sales", "Sales");
            departments.put("Cleaning service", "Cleaning");
        }
        carBrands = new HashMap<>();
        carBrands.put("BMW", "BMW");
        carBrands.put("Mazda", "Mazda");
        carBrands.put("Mercedes-Benz", "MB");
        carBrands.put("Lada", "Lada");

        languageList = new HashMap<>();
        languageList.put("English", "EN");
        languageList.put("Deutch", "DE");
        languageList.put("languages of the far north", "NO");
        languageList.put("China", "CH");
    }

    public Friend(final String author, final String bookName, final int rating) {
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Map<String, String> getDepartments() {
        return departments;
    }

    public void setDepartments(Map<String, String> departments) {
        this.departments = departments;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public Map<String, String> getCarBrands() {
        return carBrands;
    }

    public void setCarBrands(Map<String, String> carBrands) {
        this.carBrands = carBrands;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public Map<String, String> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(Map<String, String> languageList) {
        this.languageList = languageList;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
