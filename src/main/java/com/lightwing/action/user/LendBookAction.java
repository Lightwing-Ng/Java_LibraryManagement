package com.lightwing.action.user;

import com.lightwing.bean.BooksBean;
import com.lightwing.bean.LendBean;
import com.lightwing.bean.UserBean;
import com.lightwing.bean.db.DataBean;
import com.lightwing.util.MyDate;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class LendBookAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        int users_ID = ((UserBean) request.getSession().getAttribute("user")).getUsers_ID();
        int books_ID = Integer.parseInt(request.getParameter("books_ID"));
        int lendDay = Integer.parseInt(request.getParameter("lendDay"));
        String laction = request.getParameter("laction");
        LendBean lb = new LendBean();
        lb.setUsers_ID(users_ID);
        lb.setBooks_ID(books_ID);
        lb.setBookLend_StarTime(MyDate.getDate());
        MyDate md = new MyDate();
        String msg;
        lb.setBookLend_EndTime(md.addDays(lb.getBookLend_StarTime(), lendDay));
        if (laction.equals("insert")) {
            DataBean db = new DataBean();
            msg = db.lendBooks(lb);
            db.Close();
        } else {
            msg = "删除成功";
        }
        ArrayList list = (ArrayList) request.getSession().getAttribute("car");
        for (int i = 0; i < list.size(); i++) {
            BooksBean bsb = (BooksBean) list.get(i);
            if (bsb.getBooks_ID() == lb.getBooks_ID()) {
                list.remove(i);
                break;
            }
        }
        request.setAttribute("lendMsg", msg);

        return mapping.findForward("car");
    }
}
