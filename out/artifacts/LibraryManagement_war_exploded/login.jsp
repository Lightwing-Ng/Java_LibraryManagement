<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<html:html>
    <head>
        <title>
            <bean:message key="jsp.user.login.title"/>
        </title>
    </head>
    <body bgcolor="#ffffff">
    <center>
        <h1>
            <bean:message key="jsp.user.login.title"/>
        </h1>
        <html:form action="UsersLoginAction.do" method="post">
            <table>
                <tr>
                    <td><bean:message key="jsp.user.login.username"/>
                        <html:text property="users_Name"></html:text><font color="red"><html:errors
                                property="nameerr"/></font>
                    </td>
                </tr>
                <tr>
                    <td><bean:message key="jsp.user.login.userpwd"/>
                        <html:password property="users_Pwd"/><font color="red"><html:errors
                                property="pwderr"/></font>
                    </td>
                </tr>
                <tr>
                    <td>
                        <html:submit property="Submit"><bean:message key="jsp.user.login.loginbut"/></html:submit>
                        <html:reset><bean:message key="jsp.user.login.rebut"/></html:reset>
                        <html:link href="#"
                                   onclick="javascript:window.open('reg.jsp');"><bean:message
                                key="jsp.user.login.reg"/></html:link>
                    </td>
                </tr>
            </table>
        </html:form>
    </center>
    </body>
</html:html>
