<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tags/bookname.tld" prefix="b" %>
<%@ taglib uri="/WEB-INF/tags/datectrl.tld" prefix="date" %>
<center>
    <h1>
        以借图书
    </h1>
    <table border="1">
        <tr>
            <th>图书编号</th>
            <th>图书名字</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>剩余天数</th>
        </tr>
        <c:forEach var="booklend" items="${requestScope.list}">
            <tr>
                <td>${booklend.books_ID}</td>
                <td><b:booksname>${booklend.books_ID}</b:booksname></td>
                <td>
                    <script type=""
                            language="javascript">printTime('${booklend.bookLend_StarTime}')</script>
                </td>
                <td>
                    <script type=""
                            language="javascript">printTime('${booklend.bookLend_EndTime}')</script>
                </td>
                <td><date:datejian>${booklend.bookLend_EndTime}</date:datejian></td>
            </tr>
        </c:forEach>
    </table>
</center>
