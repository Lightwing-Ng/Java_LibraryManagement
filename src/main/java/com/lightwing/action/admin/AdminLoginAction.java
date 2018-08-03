package com.lightwing.action.admin;

import com.lightwing.bean.AdminBean;
import com.lightwing.bean.db.DataBean;
import com.lightwing.formbean.admin.AdminLoginForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLoginAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        AdminLoginForm adminLoginForm = (AdminLoginForm) form;
        AdminBean ab = new AdminBean();
        ab.setAdmin_Name(adminLoginForm.getAdmin_Name());
        ab.setAdmin_Pwd(adminLoginForm.getAdmin_Pwd());
        DataBean db = new DataBean();
        if (db.checkAdminLogin(ab)) {
            request.getSession().setAttribute("admin", db.getAdminBean(ab));
            request.setAttribute("LoginMsg", "<script>alert('登陆成功')</script>");
        } else {
            request.setAttribute("LoginMsg", "<script>alert('登陆失败')</script>");
        }
        db.Close();
        return mapping.findForward("admin_index");
    }
}
