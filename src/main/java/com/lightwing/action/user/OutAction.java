package com.lightwing.action.user;

import com.lightwing.tookit.MyForward;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OutAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        return MyForward.forward(mapping.findForward("index"),
                "?action=3");
    }
}
