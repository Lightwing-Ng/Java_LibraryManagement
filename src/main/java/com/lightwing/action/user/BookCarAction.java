package com.lightwing.action.user;

import com.lightwing.bean.BooksBean;
import com.lightwing.bean.db.DataBean;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class BookCarAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        HttpSession session = request.getSession();
        int books_ID = Integer.parseInt(request.getParameter("books_ID"));
        if (session.getAttribute("car") == null) {
            ArrayList list = new ArrayList();
            session.setAttribute("car", list);
        }
        DataBean db = new DataBean();
        ArrayList list = (ArrayList) session.getAttribute("car");
        boolean flag = true;
        for (Object aList : list) {
            BooksBean bsb = (BooksBean) aList;
            if (books_ID == bsb.getBooks_ID()) {
                flag = false;
                break;
            }
        }
        if (flag)
            list.add(db.getBooksBean(books_ID));
        session.setAttribute("car", list);
        db.Close();
        return mapping.findForward("car");
    }
}
