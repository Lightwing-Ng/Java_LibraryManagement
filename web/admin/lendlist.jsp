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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tags/bookname.tld" prefix="b" %>
<%@ taglib uri="/WEB-INF/tags/datectrl.tld" prefix="date" %>
<%@ taglib uri="/WEB-INF/tags/username.tld" prefix="u" %>
<center>
<h1>
�Խ�ͼ��
</h1>
<table border="1">
<tr>
<th>ͼ����</th> <th>ͼ������</th> <th>��ʼʱ��</th> <th>����ʱ��</th> <th>ʣ������</th><th>�û�</th>
</tr>
<c:forEach var="booklend" items="${requestScope.list}">
<tr>
<td>${booklend.books_ID}</td> <td><b:booksname>${booklend.books_ID}</b:booksname></td> <td><script type="" language="javascript">printTime('${booklend.bookLend_StarTime}')</script></td> <td><script type="" language="javascript">printTime('${booklend.bookLend_EndTime}')</script></td> <td><date:datejian>${booklend.bookLend_EndTime}</date:datejian></td><td><u:getname>${booklend.users_ID}</u:getname></td>
</tr>
</c:forEach>
</table>
<table>
<tr>
<td><a href="LendPageAction.do?page=${requestScope.page-1<=0?"1":requestScope.page-1}">��һҳ</a></td><td><a href="LendPageAction.do?page=${requestScope.page+1>=requestScope.pagecount?requestScope.pagecount:requestScope.page+1}">��һҳ</a></td><td>${requestScope.page}/${requestScope.pagecount}ҳ</td>
</tr>
</table>
</center>
</center>
