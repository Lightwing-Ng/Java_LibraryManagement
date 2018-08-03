package com.lightwing.util;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class MyString {
    public MyString() {
    }

    public static boolean checkParameter(String para) { // ���˷Ƿ��ַ�
        int flag = 0;
        flag += para.indexOf("'") + 1;
        flag += para.indexOf(";") + 1;
        flag += para.indexOf("1=1") + 1;
        flag += para.indexOf("|") + 1;
        flag += para.indexOf("<") + 1;
        flag += para.indexOf(">") + 1;
        return flag == 0;
    }
}
