package com.lightwing.action.admin;

import com.lightwing.bean.db.DataBean;
import com.lightwing.tookit.MyForward;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class UsersPageAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        int count = 10;
        int page = 1;
        DataBean db = new DataBean();
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
            page = page == 0 ? 1 : page;
        }
        ArrayList list = db.getUsersList(count, page);
        request.setAttribute("page", page + "");
        request.setAttribute("pagecount", db.pagecount + "");
        request.setAttribute("list", list);
        db.Close();
        return MyForward.forward(mapping.findForward("admin_index"),
                "?action=4");
    }
}
