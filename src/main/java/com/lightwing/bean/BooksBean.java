package com.lightwing.bean;

import java.io.Serializable;

public class BooksBean implements Serializable {
    private int books_ID;
    private String books_Name;
    private String books_Company;
    private int books_Count;
    private String books_Time;
    private int books_Amount;
    private int bookType_ID;

    public BooksBean() {
    }

    public void setBooks_ID(int books_ID) {
        this.books_ID = books_ID;
    }

    public void setBooks_Name(String books_Name) {
        this.books_Name = books_Name;
    }

    public void setBooks_Company(String books_Company) {
        this.books_Company = books_Company;
    }

    public void setBooks_Count(int books_Count) {
        this.books_Count = books_Count;
    }

    public void setBooks_Time(String books_Time) {
        this.books_Time = books_Time;
    }

    public void setBooks_Amount(int books_Amount) {
        this.books_Amount = books_Amount;
    }

    public void setBookType_ID(int bookType_ID) {
        this.bookType_ID = bookType_ID;
    }

    public int getBooks_ID() {
        return books_ID;
    }

    public String getBooks_Name() {
        return books_Name;
    }

    public String getBooks_Company() {
        return books_Company;
    }

    public int getBooks_Count() {
        return books_Count;
    }

    public String getBooks_Time() {
        return books_Time;
    }

    public int getBooks_Amount() {
        return books_Amount;
    }

    public int getBookType_ID() {
        return bookType_ID;
    }
}
