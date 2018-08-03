<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<jsp:include page="isLogin.jsp"/>
<html>
<head>
    <title>
        jsp1
    </title>
    <script type="" language="javascript" src="js/public.js"></script>
</head>
<body bgcolor="#ffffff">
<center>
    <table>
        <tr>
            <th>
                <a href="BooksPageAction.do"><bean:message key="jsp.user.index.menu.scanbooks"/></a>
            </th>
            <th>
                <a href="LendBookListAction.do"><bean:message
                        key="jsp.user.index.menu.scanlendbook"/></a>
            </th>
            <th>
                <a href="UserPunishPageAction.do?page=1"><bean:message
                        key="jsp.user.index.menu.scanpunish"/></a>
            </th>
            <th>
                <a href="index.jsp?action=4"><bean:message
                        key="jsp.user.index.menu.chengeinfo"/></a>
            </th>
            <th>
                <a href="OutAction.do"><bean:message key="jsp.user.index.menu.loginout"/></a>
            </th>
        </tr>
    </table>
    <table>
        <tbody>
        <logic:equal parameter="action" value="1">
            <jsp:include page="booklist.jsp"/>
        </logic:equal>
        <logic:equal parameter="action" value="2">
            <jsp:include page="lendlist.jsp"/>
        </logic:equal>
        <logic:equal parameter="action" value="3">
            <jsp:include page="punishlist.jsp"/>
        </logic:equal>
        <logic:equal parameter="action" value="4">
            <jsp:include page="editinfo.jsp"/>
        </logic:equal>
        </tbody>
    </table>
</center>
</body>
</html>
