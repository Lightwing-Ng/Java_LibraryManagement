package com.lightwing.tags;

import com.lightwing.bean.db.DataBean;
import com.lightwing.util.MyDate;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

public class DateOptionTag extends BodyTagSupport {
    public int doAfterBody() {
        BodyContent body = getBodyContent();
        String content = body.getString();
        DataBean db = new DataBean();
        String msg;
        int day = db.getDateCha(MyDate.getDate().substring(0, 8), content.substring(0, 8));
        if (day < 0) {
            msg = "以过期" + (day * -1) + "天";
        } else if (day == 0) {
            msg = "今天以到期 尽快反还";
        } else {
            msg = "还有" + day + "天";
        }
        db.Close();
        JspWriter out = body.getEnclosingWriter();
        try {
            out.print(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (SKIP_BODY);
    }
}
