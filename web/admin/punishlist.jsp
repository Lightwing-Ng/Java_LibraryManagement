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
${requestScope.DeletePunishMsg}
<center>
<h1>
�鿴����
</h1>
<table border="1">
<tr>
<th>�û�ID</th> <th>�û�����</th> <th>����ͼ��</th> <th>������</th> <th>�������</th><th>����</th>
</tr>
<c:forEach var="punish" items="${requestScope.list}">
<tr>
<td>${punish.users_ID}</td> <td><u:getname>${punish.users_ID}</u:getname></td> <td><b:booksname>${punish.books_ID}</b:booksname></td> <td>${punish.punish_Day}</td> <td>${punish.punish_Money}</td><td><a href="DeletePunishAction.do?punish_ID=${punish.punish_ID}">����</a></td>
</tr>
</c:forEach>
</table>
<table>
<tr>
<td><a href="PunishPageAction.do?page=${requestScope.page-1<=0?"1":requestScope.page-1}">��һҳ</a></td><td><a href="PunishPageAction.do?page=${requestScope.page+1>=requestScope.pagecount?requestScope.pagecount:requestScope.page+1}">��һҳ</a></td><td>${requestScope.page}/${requestScope.pagecount}ҳ</td>
</tr>
</table>
</center>
