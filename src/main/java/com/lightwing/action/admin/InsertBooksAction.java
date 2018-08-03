package com.lightwing.action.admin;

import com.lightwing.bean.BooksBean;
import com.lightwing.bean.db.DataBean;
import com.lightwing.formbean.admin.InsertBooksForm;
import com.lightwing.tookit.MyForward;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertBooksAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        InsertBooksForm insertBooksForm = (InsertBooksForm) form;
        BooksBean bsb = new BooksBean();
        bsb.setBooks_Company(insertBooksForm.getBooks_Company());
        bsb.setBooks_Count(insertBooksForm.getBooks_Count());
        bsb.setBooks_Name(insertBooksForm.getBooks_Name());
        bsb.setBookType_ID(insertBooksForm.getBookType_ID());
        DataBean db = new DataBean();
        if (db.insertBooks(bsb)) {
            request.setAttribute("InsertBooksMsg", "<script>alert('录入成功')</script>");
        } else {
            request.setAttribute("InsertBooksMsg", "<script>alert('录入失败')</script>");
        }
        db.Close();
        return MyForward.forward(mapping.findForward("admin_index"), "?action=1");
    }
}
