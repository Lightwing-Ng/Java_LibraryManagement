<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tags/bookname.tld" prefix="b" %>
<%@ taglib uri="/WEB-INF/tags/datectrl.tld" prefix="date" %>
<%@ taglib uri="/WEB-INF/tags/username.tld" prefix="u" %>
<center>
    <h1>
        �鿴����
    </h1>
    <table border="1">
        <tr>
            <th>�û�ID</th>
            <th>�û�����</th>
            <th>����ͼ��</th>
            <th>������</th>
            <th>�������</th>
        </tr>
        <c:forEach var="punish" items="${requestScope.list}">
            <tr>
                <td>${punish.users_ID}</td>
                <td><u:getname>${punish.users_ID}</u:getname></td>
                <td><b:booksname>${punish.books_ID}</b:booksname></td>
                <td>${punish.punish_Day}</td>
                <td>${punish.punish_Money}</td>
            </tr>
        </c:forEach>
    </table>
    <table>
        <tr>
            <td>
                <a href="UserPunishPageAction.do?page=${requestScope.page-1<=0?"1":requestScope.page-1}">��һҳ</a>
            </td>
            <td>
                <a href="UserPunishPageAction.do?page=${requestScope.page+1>=requestScope.pagecount?requestScope.pagecount:requestScope.page+1}">��һҳ</a>
            </td>
            <td>${requestScope.page}/${requestScope.pagecount}ҳ</td>
        </tr>
    </table>
</center>

