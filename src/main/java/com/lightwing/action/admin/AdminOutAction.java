package com.lightwing.action.admin;

import com.lightwing.tookit.MyForward;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminOutAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        request.getSession().removeAttribute("admin");
        return MyForward.forward(mapping.findForward("admin_index"),
                "?action=3");
    }
}
