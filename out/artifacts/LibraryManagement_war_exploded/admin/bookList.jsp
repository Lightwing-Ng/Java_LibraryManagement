<%--////////////////////////////////////////////////////GTONԭ����Ʒ-Strutsͼ��ݹ���ϵͳ//////////////////////////////////////////////////////////////
////////////���ü���:jsp2.0+servlet2.4+jstl1.1+Struts1.2+sqlserver2000+tomcat5.5/////////////////////////////////////
/////////////////////////////////////////////////////רҵ������վ רҵ������ҵ���////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////QQ:27612285//////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////Mail:punkwang@126.com////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////WEB:www.98202.com www.630cn.com//////////////////////////////////////////////////////
////////////////////////////////////////////////////qqȺ:20665503////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////���н����һ����������ϵ����/////////////////////////////////////////////////////////
////////////////////////////////////////////////////Phone:010-81110277(������)///////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////--%>
<%--�� ��ҵ���ҵ�� ��վҵ�� ��ҵ��վ ������վ �̳�ϵͳ ��ҵ��ҳ JSP ASP.net PHP !!! 

ҵ������ 

��վҵ�� ��ҵ��վ ������վ �̳�ϵͳ ��ҵ��ҳ ����С����վ��asp, jsp ,php ,asp.net�� 

��ҵ���ҵ��:java��j2ee j2se�� vb delphi php .net�ȱ���ҵ�� 

ģ��ҵ�񣺸�����С��ģ�� java .net 

������Ҫ �۸�ϸ̸ QQ:27612285 

�ҵ���վ 
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
ͼ�����
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
  ��ѯ: <select name="seach">
  <option value="1">������</option>
  <option value="2">��������</option>
  <option value="3">ȫ��</option>
  </select>
  ��ѯ����: <select name="bookTypeID">
  <b:bookstype>option</b:bookstype>
   </select>
   ��ѯ����:<input type="text" name="seachstr" /><input onclick="Seach()" type="button" value="��ѯ" />
</form>
</td>
</tr>
</table>
<table border="1">
<tr>
<td>���</td> <td>����</td> <td>������</td> <td>����</td> <td>����</td> <td>����</td>
</tr>
<c:forEach var="books" items="${requestScope.list}">
<tr>
<td>${books.books_ID}</td> <td>${books.books_Name}</td> <td>${books.books_Company}</td> <td><b:bookstype>${books.bookType_ID}</b:bookstype></td> <td>${books.books_Count}</td> <td><a onclick="javascript:window.open('EditBooksAction.do?books_ID=${books.books_ID}')" href="#">�༭</a></td>
</tr>
</c:forEach>
</table>
<table>
<tr>
<td><a href="javascript:BooksPage('${requestScope.page-1<=0?"1":requestScope.page-1}','${requestScope.seach}','${requestScope.bookTypeID}','${requestScope.seachstr}')">��һҳ</a></td><td><a href="javascript:BooksPage('${requestScope.page+1>=requestScope.pagecount?requestScope.pagecount:requestScope.page+1}','${requestScope.seach}','${requestScope.bookTypeID}','${requestScope.seachstr}')">��һҳ</a></td><td>${requestScope.page}/${requestScope.pagecount}ҳ</td>
</tr>
</table>
</center>
