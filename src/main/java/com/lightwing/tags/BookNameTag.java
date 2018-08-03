package com.lightwing.tags;

import com.lightwing.bean.db.DataBean;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

public class BookNameTag extends BodyTagSupport {
    public int doAfterBody() {
        BodyContent body = getBodyContent();
        String content = body.getString();
        JspWriter out = body.getEnclosingWriter();
        DataBean db = new DataBean();
        int bookID = Integer.parseInt(content);
        String name = db.getBooksBean(bookID).getBooks_Name();
        db.Close();
        try {
            out.print(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (SKIP_BODY);
    }
}
