package com.lightwing.tookit;

import org.apache.struts.action.ActionForward;

public class MyForward {
    public MyForward() {
    }

    public static ActionForward forward(ActionForward forward, String param) {
        return new ActionForward(forward.getPath() + param);
    }
}
