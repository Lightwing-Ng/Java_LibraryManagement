<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tags/booktype.tld" prefix="b" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<center>
    <h1>
        ͼ�����
    </h1>
    <table>
        <tr>
            <b:bookstype>tr</b:bookstype>
        </tr>
    </table>
    <table>
        <tr>
            <td>
                <form name="form1" method="GET" action="BooksPageAction.do">
                    ��ѯ: <select name="seach">
                    <option value="1">������</option>
                    <option value="2">��������</option>
                    <option value="3">ȫ��</option>
                </select>
                    ��ѯ����: <label>
                    <select name="bookTypeID">
                        <b:bookstype>option</b:bookstype>
                    </select>
                </label>
                    ��ѯ����:<label>
                    <input type="text" name="seachstr"/>
                </label><input onclick="Seach()" type="button"
                               value="��ѯ"/>
                </form>
            </td>
        </tr>
    </table>
    <table border="1">
        <tr>
            <td>���</td>
            <td>����</td>
            <td>������</td>
            <td>����</td>
            <td>����</td>
            <td>����</td>
        </tr>
        <c:forEach var="books" items="${requestScope.list}">
            <tr>
                <td>${books.books_ID}</td>
                <td>${books.books_Name}</td>
                <td>${books.books_Company}</td>
                <td><b:bookstype>${books.bookType_ID}</b:bookstype></td>
                <td>${books.books_Count}</td>
                <td>
                    <a onclick="javascript:window.open('BookCarAction.do?books_ID=${books.books_ID}')"
                       href="#">�����</a></td>
            </tr>
        </c:forEach>
    </table>
    <table>
        <tr>
            <td>
                <a href="javascript:BooksPage('${requestScope.page-1<=0?"1":requestScope.page-1}','${requestScope.seach}','${requestScope.bookTypeID}','${requestScope.seachstr}')">��һҳ</a>
            </td>
            <td>
                <a href="javascript:BooksPage('${requestScope.page+1>=requestScope.pagecount?requestScope.pagecount:requestScope.page+1}','${requestScope.seach}','${requestScope.bookTypeID}','${requestScope.seachstr}')">��һҳ</a>
            </td>
            <td>${requestScope.page}/${requestScope.pagecount}ҳ</td>
        </tr>
    </table>
</center>
