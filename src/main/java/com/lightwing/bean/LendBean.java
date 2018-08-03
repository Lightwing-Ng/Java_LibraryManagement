package com.lightwing.bean;

public class LendBean {
    private int bookLend_ID;
    private int users_ID;
    private int books_ID;
    private String bookLend_StarTime;
    private String bookLend_EndTime;

    public LendBean() {
    }

    public void setBookLend_ID(int bookLend_ID) {
        this.bookLend_ID = bookLend_ID;
    }

    public void setUsers_ID(int users_ID) {
        this.users_ID = users_ID;
    }

    public void setBooks_ID(int books_ID) {
        this.books_ID = books_ID;
    }

    public void setBookLend_StarTime(String bookLend_StarTime) {
        this.bookLend_StarTime = bookLend_StarTime;
    }

    public void setBookLend_EndTime(String bookLend_EndTime) {
        this.bookLend_EndTime = bookLend_EndTime;
    }

    public int getBookLend_ID() {
        return bookLend_ID;
    }

    public int getUsers_ID() {
        return users_ID;
    }

    public int getBooks_ID() {
        return books_ID;
    }

    public String getBookLend_StarTime() {
        return bookLend_StarTime;
    }

    public String getBookLend_EndTime() {
        return bookLend_EndTime;
    }
}
