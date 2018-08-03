package com.lightwing.formbean;

import com.lightwing.bean.UserBean;
import com.lightwing.bean.db.DataBean;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;

public class UsersChengeInfoForm extends ActionForm {
    private String user_b;
    private String user_n;
    private String users_Adds;
    private int users_ID;
    private String users_Name;
    private String users_OldPwd;
    private String users_Phone;
    private String users_Pwd;
    private String users_Pwd1;
    private String users_Sex;

    public String getUser_b() {
        return user_b;
    }

    public void setUser_b(String user_b) {
        this.user_b = user_b;
    }

    public void setUsers_Sex(String users_Sex) {
        this.users_Sex = users_Sex;
    }

    public void setUsers_Pwd1(String users_Pwd1) {
        this.users_Pwd1 = users_Pwd1;
    }

    public void setUsers_Pwd(String users_Pwd) {
        this.users_Pwd = users_Pwd;
    }

    public void setUsers_Phone(String users_Phone) {
        this.users_Phone = users_Phone;
    }

    private void setUsers_OldPwd(String users_OldPwd) {
        this.users_OldPwd = users_OldPwd;
    }

    public void setUsers_Name(String users_Name) {
        this.users_Name = users_Name;
    }

    public void setUsers_ID(int users_ID) {
        this.users_ID = users_ID;
    }

    public void setUsers_Adds(String users_Adds) {
        this.users_Adds = users_Adds;
    }

    public void setUser_n(String user_n) {
        this.user_n = user_n;
    }

    public String getUser_n() {
        return user_n;
    }

    public String getUsers_Adds() {
        return users_Adds;
    }

    public int getUsers_ID() {
        return users_ID;
    }

    public String getUsers_Name() {
        return users_Name;
    }

    public String getUsers_OldPwd() {
        return users_OldPwd;
    }

    public String getUsers_Phone() {
        return users_Phone;
    }

    private String getUsers_Pwd() {
        return users_Pwd;
    }

    private String getUsers_Pwd1() {
        return users_Pwd1;
    }

    public String getUsers_Sex() {
        return users_Sex;
    }

    public ActionErrors validate(ActionMapping actionMapping,
                                 HttpServletRequest httpServletRequest) {
        ActionErrors err = new ActionErrors();
        UserBean ub = (UserBean) httpServletRequest.getSession().getAttribute("user");
        if (this.getUser_b() == null || this.getUser_b().length() < 1) {
            err.add("classerr", new ActionMessage("jsp.user.reg.class.berr"));
        } else if (this.getUser_n() == null || this.getUser_n().length() < 1) {
            err.add("classerr", new ActionMessage("jsp.user.reg.class.nerr"));
        } else if (this.getUsers_Name() == null || this.getUsers_Name().length() < 1) {
            err.add("nameerr", new ActionMessage("jsp.user.reg.nameerr"));
        } else if (!this.getUsers_Name().equals(ub.getUsers_Name())) {
            if (!DataBean.HasName(this.getUsers_Name()))
                err.add("nameerr", new ActionMessage("jsp.user.reg.nameerr1"));
        } else if (!this.getUsers_OldPwd().equals(ub.getUsers_Pwd())) {
            err.add("oldpwderr", new ActionMessage("jsp.user.reg.oldpwderr"));
        } else if (this.getUsers_Pwd().length() > 1) {
            if (this.getUsers_Pwd1() == null || this.getUsers_Pwd1().length() < 1) {
                err.add("pwd1err", new ActionMessage("jsp.user.reg.pwd1err"));
            } else if (!this.getUsers_Pwd1().equals(this.getUsers_Pwd())) {
                err.add("pwd2err", new ActionMessage("jsp.user.reg.pwd2err"));
            } else {
                this.setUsers_OldPwd(this.getUsers_Pwd());
            }
        } else if (this.getUsers_Sex() == null || this.getUsers_Sex().length() < 1) {
            err.add("sexerr", new ActionMessage("jsp.user.reg.sexerr"));
        } else if (this.getUsers_Phone() == null || this.getUsers_Phone().length() < 1) {
            err.add("phoneerr", new ActionMessage("jsp.user.reg.phoneerr"));
        } else if (this.getUsers_Adds() == null || this.getUsers_Adds().length() < 1) {
            err.add("addserr", new ActionMessage("jsp.user.reg.addserr"));
        }
        return err;
    }

    public void reset(ActionMapping actionMapping,
                      HttpServletRequest servletRequest) {
    }
}
