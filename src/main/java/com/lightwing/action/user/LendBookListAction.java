package com.lightwing.action.user;

import com.lightwing.bean.UserBean;
import com.lightwing.bean.db.DataBean;
import com.lightwing.tookit.MyForward;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class LendBookListAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        UserBean ub = (UserBean) request.getSession().getAttribute("user");
        DataBean db = new DataBean();
        ArrayList list = db.getUsersLendList(ub.getUsers_ID());
        request.setAttribute("list", list);
        return MyForward.forward(mapping.findForward("index"), "?action=2");
    }
}
