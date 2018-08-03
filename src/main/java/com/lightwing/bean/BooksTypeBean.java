package com.lightwing.bean;

public class BooksTypeBean {
    private int bookType_ID;
    private String bookType_Name;

    public BooksTypeBean() {
    }

    public void setBookType_ID(int bookType_ID) {
        this.bookType_ID = bookType_ID;
    }

    public void setBookType_Name(String bookType_Name) {
        this.bookType_Name = bookType_Name;
    }

    public int getBookType_ID() {
        return bookType_ID;
    }

    public String getBookType_Name() {
        return bookType_Name;
    }
}
