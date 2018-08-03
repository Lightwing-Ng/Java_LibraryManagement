package com.lightwing.action.admin;

import com.lightwing.bean.BooksBean;
import com.lightwing.bean.db.DataBean;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditBooksAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        int books_ID = Integer.parseInt(request.getParameter("books_ID"));
        DataBean db = new DataBean();
        BooksBean bsb = db.getBooksBean(books_ID);
        request.setAttribute("books", bsb);
        db.Close();
        return mapping.findForward("updateBook");
    }
}
