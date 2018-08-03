package com.lightwing.action.admin;

import com.lightwing.bean.db.DataBean;
import com.lightwing.tookit.MyForward;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class AdminBooksPageAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        int page = 1;
        int count = 10;
        String sqlStr = "";
        String seach = "";
        String bookTypeID = "0";
        String seachstr = "";
        if (request.getParameter("seachstr") != null && request.getParameter("seachstr").length() > 0) {
            try {
                seachstr = new String(request.getParameter("seachstr").getBytes("8859_1"), "GB2312");
                System.out.println(seachstr);
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
        }
        if (request.getParameter("page") != null && request.getParameter("page").length() > 0) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        if (request.getParameter("seach") != null && request.getParameter("seach").length() > 0) {
            seach = request.getParameter("seach");
            if (seach.equals("1")) {
                sqlStr = "where Books_Name like '%" + seachstr + "%'";
            } else if (seach.equals("2")) {
                sqlStr = "where Books_Company like '%" + seachstr + "%'";
            } else if (seach.equals("3")) {
                sqlStr = "where Books_Company like '%" + seachstr + "%' or Books_Name like '%" + seachstr + "%'";
            }
        }
        if (request.getParameter("bookTypeID") != null && request.getParameter("bookTypeID").length() > 0) {
            bookTypeID = request.getParameter("bookTypeID");
        }
        if (sqlStr.equals("")) {
            if (!bookTypeID.equals("0"))
                sqlStr = "where BookType_ID=" + bookTypeID;
        } else {
            if (!bookTypeID.equals("0"))
                sqlStr += "and BookType_ID=" + bookTypeID;
        }
        DataBean db = new DataBean();
        ArrayList list = db.getBooksList(count, page, sqlStr);
        System.out.println(list.size());
        db.Close();
        request.setAttribute("list", list);
        request.setAttribute("page", page + "");
        request.setAttribute("pagecount", db.pagecount + "");
        request.setAttribute("bookTypeID", bookTypeID);
        request.setAttribute("seach", seach);
        request.setAttribute("seachstr", seachstr);
        return MyForward.forward(mapping.findForward("admin_index"), "?action=2");

    }
}
