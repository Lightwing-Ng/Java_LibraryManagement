<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tags/booktype.tld" prefix="b" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<center>
    <h1>
        图书浏览
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
                    查询: <select name="seach">
                    <option value="1">按书名</option>
                    <option value="2">按出版社</option>
                    <option value="3">全文</option>
                </select>
                    查询类型: <label>
                    <select name="bookTypeID">
                        <b:bookstype>option</b:bookstype>
                    </select>
                </label>
                    查询内容:<label>
                    <input type="text" name="seachstr"/>
                </label><input onclick="Seach()" type="button"
                               value="查询"/>
                </form>
            </td>
        </tr>
    </table>
    <table border="1">
        <tr>
            <td>编号</td>
            <td>书名</td>
            <td>出版社</td>
            <td>类型</td>
            <td>数量</td>
            <td>操作</td>
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
                       href="#">借此书</a></td>
            </tr>
        </c:forEach>
    </table>
    <table>
        <tr>
            <td>
                <a href="javascript:BooksPage('${requestScope.page-1<=0?"1":requestScope.page-1}','${requestScope.seach}','${requestScope.bookTypeID}','${requestScope.seachstr}')">上一页</a>
            </td>
            <td>
                <a href="javascript:BooksPage('${requestScope.page+1>=requestScope.pagecount?requestScope.pagecount:requestScope.page+1}','${requestScope.seach}','${requestScope.bookTypeID}','${requestScope.seachstr}')">下一页</a>
            </td>
            <td>${requestScope.page}/${requestScope.pagecount}页</td>
        </tr>
    </table>
</center>
