<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>
        <bean:message key="jsp.user.regmsg.title"/>
    </title>
</head>
<body bgcolor="#ffffff">
<center>

    <h1>
        <bean:message key="jsp.user.regmsg.title"/>
    </h1>
    <table>
        <tr>
            <td>
                <logic:equal name="regMsg" value="ok">
                    <a href="index.jsp"><bean:message key="jsp.user.regmsg.ok"/></a>
                </logic:equal>
                <logic:equal name="regMsg" value="no">
                    <a href="reg.jsp"><bean:message key="jsp.user.regmsg.no"/></a>
                </logic:equal>
            </td>
        </tr>
    </table>
</center>
</body>
</html>
