package com.lightwing.action.user;

import com.lightwing.bean.UserBean;
import com.lightwing.bean.db.DataBean;
import com.lightwing.formbean.UsersRegForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsersRegAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        UsersRegForm usersRegForm = (UsersRegForm) form;
        DataBean db = new DataBean();
        UserBean ub = new UserBean();
        ub.setUsers_Adds(usersRegForm.getUsers_Adds());
        ub.setUsers_Class(usersRegForm.getUser_n() + "年级" + usersRegForm.getUser_b() + "班");
        ub.setUsers_Name(usersRegForm.getUsers_Name());
        ub.setUsers_Phone(usersRegForm.getUsers_Phone());
        ub.setUsers_Pwd(usersRegForm.getUsers_Pwd());
        ub.setUsers_Sex(usersRegForm.getUsers_Sex());
        if (db.regUser(ub)) {
            request.setAttribute("regMsg", "ok");
            request.getSession().setAttribute("user", db.getUserBean(ub));
        } else {
            request.setAttribute("regMsg", "no");
        }
        db.Close();
        return mapping.findForward("regMsg");
    }
}
