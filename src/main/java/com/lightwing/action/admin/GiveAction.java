package com.lightwing.action.admin;

import com.lightwing.bean.LendBean;
import com.lightwing.bean.db.DataBean;
import com.lightwing.formbean.admin.GiveForm;
import com.lightwing.tookit.MyForward;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GiveAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        GiveForm giveForm = (GiveForm) form;
        DataBean db = new DataBean();
        LendBean lb = db.getLendBean(giveForm.getUsers_ID(), giveForm.getBooks_ID());
        request.setAttribute("GiveMsg", "<script>alert('" + db.giveBook(lb) + "')</script>");
        db.Close();
        return MyForward.forward(mapping.findForward("admin_index"), "?action=6");
    }
}
