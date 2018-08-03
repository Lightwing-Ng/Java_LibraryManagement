<%--////////////////////////////////////////////////////GTON原创作品-Struts图书馆管理系统//////////////////////////////////////////////////////////////
////////////所用技术:jsp2.0+servlet2.4+jstl1.1+Struts1.2+sqlserver2000+tomcat5.5/////////////////////////////////////
/////////////////////////////////////////////////////专业制作网站 专业制作毕业设计////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////QQ:27612285//////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////Mail:punkwang@126.com////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////WEB:www.98202.com www.630cn.com//////////////////////////////////////////////////////
////////////////////////////////////////////////////qq群:20665503////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////求高薪工作一个有意者联系本人/////////////////////////////////////////////////////////
////////////////////////////////////////////////////Phone:010-81110277(王先生)///////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////--%>
<%--接 毕业设计业务 网站业务 商业网站 个人网站 商城系统 企业主页 JSP ASP.net PHP !!! 

业务种类 

网站业务： 商业网站 个人网站 商城系统 企业主页 等中小型网站（asp, jsp ,php ,asp.net） 

毕业设计业务:java（j2ee j2se） vb delphi php .net等毕设业务 

模块业务：各种中小型模块 java .net 

如有需要 价格细谈 QQ:27612285 

我的网站 
HTTP://www.98202.com 
HTTP://www.do3w.com 
HTTP://www.201cn.com 
HTTP://www.630cn.com--%>
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
<b:bookstype>admintr</b:bookstype>
</tr>
</table>
<table>
<tr>
<td>
<form name="form1" method="GET" action="AdminBooksPageAction.do">
  查询: <select name="seach">
  <option value="1">按书名</option>
  <option value="2">按出版社</option>
  <option value="3">全文</option>
  </select>
  查询类型: <select name="bookTypeID">
  <b:bookstype>option</b:bookstype>
   </select>
   查询内容:<input type="text" name="seachstr" /><input onclick="Seach()" type="button" value="查询" />
</form>
</td>
</tr>
</table>
<table border="1">
<tr>
<td>编号</td> <td>书名</td> <td>出版社</td> <td>类型</td> <td>数量</td> <td>操作</td>
</tr>
<c:forEach var="books" items="${requestScope.list}">
<tr>
<td>${books.books_ID}</td> <td>${books.books_Name}</td> <td>${books.books_Company}</td> <td><b:bookstype>${books.bookType_ID}</b:bookstype></td> <td>${books.books_Count}</td> <td><a onclick="javascript:window.open('EditBooksAction.do?books_ID=${books.books_ID}')" href="#">编辑</a></td>
</tr>
</c:forEach>
</table>
<table>
<tr>
<td><a href="javascript:BooksPage('${requestScope.page-1<=0?"1":requestScope.page-1}','${requestScope.seach}','${requestScope.bookTypeID}','${requestScope.seachstr}')">上一页</a></td><td><a href="javascript:BooksPage('${requestScope.page+1>=requestScope.pagecount?requestScope.pagecount:requestScope.page+1}','${requestScope.seach}','${requestScope.bookTypeID}','${requestScope.seachstr}')">下一页</a></td><td>${requestScope.page}/${requestScope.pagecount}页</td>
</tr>
</table>
</center>
