package com.lightwing.formbean;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;

public class UsersLoginForm extends ActionForm {
    private String users_Name;
    private String users_Pwd;

    public String getUsers_Name() {
        return users_Name;
    }

    public void setUsers_Name(String users_Name) {
        this.users_Name = users_Name;
    }

    public void setUsers_Pwd(String users_Pwd) {
        this.users_Pwd = users_Pwd;
    }

    public String getUsers_Pwd() {
        return users_Pwd;
    }

    public ActionErrors validate(ActionMapping actionMapping,
                                 HttpServletRequest httpServletRequest) {
        /* @todo: finish this method, this is just the skeleton.*/
        ActionErrors err = new ActionErrors();
        if (this.getUsers_Name() == null || this.getUsers_Name().length() < 1) {
            err.add("nameerr", new ActionMessage("err.user.login.namenullerr"));
        }
        if (this.getUsers_Pwd() == null || this.getUsers_Pwd().length() < 1) {
            err.add("pwderr", new ActionMessage("err.user.login.pwdnullerr"));
        }
        return err;
    }

    public void reset(ActionMapping actionMapping,
                      HttpServletRequest servletRequest) {
    }
}
