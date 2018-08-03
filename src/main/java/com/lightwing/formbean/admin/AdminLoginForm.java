package com.lightwing.formbean.admin;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;

public class AdminLoginForm extends ActionForm {
    private String admin_Name;
    private String admin_Pwd;

    public String getAdmin_Name() {
        return admin_Name;
    }

    public String getAdmin_Pwd() {
        return admin_Pwd;
    }

    public ActionErrors validate(ActionMapping actionMapping,
                                 HttpServletRequest httpServletRequest) {
        ActionErrors err = new ActionErrors();
        if (this.getAdmin_Name() == null || this.getAdmin_Name().length() < 1) {
            err.add("nameerr", new ActionMessage("err.user.login.namenullerr"));
        }
        if (this.getAdmin_Pwd() == null || this.getAdmin_Pwd().length() < 1) {
            err.add("pwderr", new ActionMessage("err.user.login.pwdnullerr"));
        }
        return err;
    }

    public void reset(ActionMapping actionMapping,
                      HttpServletRequest servletRequest) {
    }

    public void setAdmin_Name(String admin_Name) {
        this.admin_Name = admin_Name;
    }

    public void setAdmin_Pwd(String admin_Pwd) {
        this.admin_Pwd = admin_Pwd;
    }
}
