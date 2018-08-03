package com.lightwing.action.user;

import com.lightwing.bean.UserBean;
import com.lightwing.bean.db.DataBean;
import com.lightwing.formbean.UsersLoginForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsersLoginAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        UsersLoginForm usersLoginForm = (UsersLoginForm) form;
        UserBean ub = new UserBean();
        DataBean db = new DataBean();
        ub.setUsers_Name(usersLoginForm.getUsers_Name());
        ub.setUsers_Pwd(usersLoginForm.getUsers_Pwd());
        if (db.checkUserLogin(ub)) {
            request.getSession().setAttribute("user", db.getUserBean(ub));
        }
        db.Close();
        return mapping.findForward("index");
    }
}
