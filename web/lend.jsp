<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tags/bookname.tld" prefix="b" %>
<%@ taglib uri="/WEB-INF/tags/bookname.tld" prefix="b" %>
<html>
<head>
    <title>
        ����
    </title>
</head>
<body bgcolor="#ffffff">
<center>
    <h1>
        ����
    </h1>
    <c:forEach var="books" items="${sessionScope.car}">
        <form name="form${books.books_ID}" method="post" action="LendBookAction.do">
            <table border="1">
                <tr>
                    <td align="center">ͼ����</td>
                    <td align="center">ͼ������</td>
                    <td align="center">��������</td>
                    <td align="center">����</td>
                </tr>
                <tr>
                    <td>${books.books_ID}<input type="hidden" name="books_ID"
                                                value="${books.books_ID}"/></td>
                    <td><b:booksname>${books.books_ID}</b:booksname></td>
                    <td><select name="lendDay">
                        <option value="30">һ����</option>
                        <option value="7">һ��</option>
                    </select></td>
                    <td><input type="hidden" name="laction" value=""/><input
                            onclick="javascript:document.form${books.books_ID}.laction.value='insert';document.form${books.books_ID}.submit();"
                            type="button" value="�����"/><input
                            onclick="javascript:document.form${books.books_ID}.laction.value='del';document.form${books.books_ID}.submit();"
                            type="button" value="ɾ������"/></td>
                </tr>
            </table>
        </form>
    </c:forEach>
</center>
</body>
<c:if test="${not empty requestScope.lendMsg}">
    <script type="" language="javascript">alert('${requestScope.lendMsg}');</script>
</c:if>
</html>
