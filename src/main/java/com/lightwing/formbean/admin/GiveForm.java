package com.lightwing.formbean.admin;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;

public class GiveForm extends ActionForm {
    private int books_ID;
    private int users_ID;

    public int getBooks_ID() {
        return books_ID;
    }

    public void setBooks_ID(int books_ID) {
        this.books_ID = books_ID;
    }

    public void setUsers_ID(int users_ID) {
        this.users_ID = users_ID;
    }

    public int getUsers_ID() {
        return users_ID;
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
