package com.lightwing.action.admin;

import com.lightwing.bean.db.DataBean;
import com.lightwing.tookit.MyForward;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeletePunishAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        int punish_ID = Integer.parseInt(request.getParameter("punish_ID"));
        DataBean db = new DataBean();
        if (db.deletePunish(punish_ID)) {
            request.setAttribute("UpdatePunishMsg",
                    "<script>alert('֧支付成功')</script>");
        } else {
            request.setAttribute("DeletePunishMsg",
                    "<script>alert('֧支付失败')</script>");
        }
        return MyForward.forward(mapping.findForward("punishPage"), "?page=1");
    }
}
