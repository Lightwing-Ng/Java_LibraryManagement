package com.lightwing.tags;

import com.lightwing.bean.BooksTypeBean;
import com.lightwing.bean.db.DataBean;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;
import java.util.ArrayList;

public class BookTypeTag extends BodyTagSupport {
    public int doAfterBody() {
        BodyContent body = getBodyContent();
        String content = body.getString();
        JspWriter out = body.getEnclosingWriter();
        DataBean db = new DataBean();
        ArrayList list = db.getBooksType();
        db.Close();
        try {
            if (content.equals("tr")) {
                out.println(
                        "<th><a href='BooksPageAction.do?bookTypeID=0'>ȫ��</a></th>");
                for (Object aList : list) {
                    BooksTypeBean btb = (BooksTypeBean) aList;
                    out.println("<th><a href='BooksPageAction.do?bookTypeID=" +
                            btb.getBookType_ID() + "'>" +
                            btb.getBookType_Name() +
                            "</a></th>");
                }
            } else if (content.equals("option")) {
                out.println(
                        "<option value=\"0\">ȫ��</option>");
                for (Object aList : list) {
                    BooksTypeBean btb = (BooksTypeBean) aList;
                    out.println("<option value=\"" + btb.getBookType_ID() +
                            "\">" + btb.getBookType_Name() + "</option>");
                }

            } else if (content.equals("admintr")) {
                out.println(
                        "<th><a href='AdminBooksPageAction.do?bookTypeID=0'>ȫ��</a></th>");
                for (Object aList : list) {
                    BooksTypeBean btb = (BooksTypeBean) aList;
                    out.println("<th><a href='AdminBooksPageAction.do?bookTypeID=" +
                            btb.getBookType_ID() + "'>" +
                            btb.getBookType_Name() +
                            "</a></th>");
                }

            } else {
                for (Object aList : list) {
                    BooksTypeBean btb = (BooksTypeBean) aList;
                    if (btb.getBookType_ID() == Integer.parseInt(content)) {
                        out.print(btb.getBookType_Name());
                        break;
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (SKIP_BODY);
    }
}
