package com.lightwing.action.user;

import com.lightwing.bean.UserBean;
import com.lightwing.bean.db.DataBean;
import com.lightwing.formbean.UsersChengeInfoForm;
import com.lightwing.tookit.MyForward;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChengeUserInfoAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        UsersChengeInfoForm usersChengeInfoForm = (UsersChengeInfoForm) form;
        DataBean db = new DataBean();
        UserBean ub = new UserBean();
        ub.setUsers_Adds(usersChengeInfoForm.getUsers_Adds());
        ub.setUsers_Class(usersChengeInfoForm.getUser_n() + "年级" +
                usersChengeInfoForm.getUser_b() + "班别");
        ub.setUsers_Name(usersChengeInfoForm.getUsers_Name());
        ub.setUsers_Phone(usersChengeInfoForm.getUsers_Phone());
        ub.setUsers_Sex(usersChengeInfoForm.getUsers_Sex());
        ub.setUsers_Pwd(usersChengeInfoForm.getUsers_OldPwd());
        ub.setUsers_ID(usersChengeInfoForm.getUsers_ID());
        if (db.updateUserInfo(ub)) {
            request.setAttribute("userUpdateMsg", "ok");
            request.getSession().setAttribute("user", db.getUserBean(ub));
        } else {
            request.setAttribute("userUpdateMsg", "no");
        }
        db.Close();
        return MyForward.forward(mapping.findForward("index"), "?action=4");
    }
}
