package com.lightwing.formbean.admin;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

public class UpdateBooksForm extends ActionForm {
    private int bookType_ID;
    private String books_Company;
    private int books_Count;
    private int books_ID;
    private String books_Name;

    public int getBookType_ID() {
        return bookType_ID;
    }

    public void setBookType_ID(int bookType_ID) {
        this.bookType_ID = bookType_ID;
    }

    public void setBooks_Name(String books_Name) {
        this.books_Name = books_Name;
    }

    public void setBooks_ID(int books_ID) {
        this.books_ID = books_ID;
    }

    public void setBooks_Count(int books_Count) {
        this.books_Count = books_Count;
    }

    public void setBooks_Company(String books_Company) {
        this.books_Company = books_Company;
    }

    public String getBooks_Company() {
        return books_Company;
    }

    public int getBooks_Count() {
        return books_Count;
    }

    public int getBooks_ID() {
        return books_ID;
    }

    public String getBooks_Name() {
        return books_Name;
    }

    public ActionErrors validate(ActionMapping actionMapping,
                                 HttpServletRequest httpServletRequest) {
        /* @todo: finish this method, this is just the skeleton.*/
        return null;
    }

    public void reset(ActionMapping actionMapping,
                      HttpServletRequest servletRequest) {
    }
}
