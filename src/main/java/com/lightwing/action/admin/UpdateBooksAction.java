package com.lightwing.action.admin;

import com.lightwing.bean.BooksBean;
import com.lightwing.bean.db.DataBean;
import com.lightwing.formbean.admin.UpdateBooksForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateBooksAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        UpdateBooksForm updateBooksForm = (UpdateBooksForm) form;
        BooksBean bsb = new BooksBean();
        bsb.setBooks_Company(updateBooksForm.getBooks_Company());
        bsb.setBooks_Count(updateBooksForm.getBooks_Count());
        bsb.setBooks_ID(updateBooksForm.getBooks_ID());
        bsb.setBookType_ID(updateBooksForm.getBookType_ID());
        bsb.setBooks_Name(updateBooksForm.getBooks_Name());
        DataBean db = new DataBean();
        if (db.updateBooks(bsb)) {
            request.setAttribute("UpdateBooksMsg",
                    "<script>alert('更新成功')</script>");
        } else {
            request.setAttribute("UpdateBooksMsg",
                    "<script>alert('更新失败')</script>");
        }

        db.Close();
        return mapping.findForward("updatebooks");
    }
}
