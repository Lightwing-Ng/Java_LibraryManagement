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
<%@page contentType="text/html; charset=GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include flush="false" page="isLogin.jsp"/>
<html>
<head>
<title>Admin����</title>
<script type="" language="javascript" src="js/public.js"></script>
</head>
<body bgcolor="#ffffff">
<center>
  <table>
    <tr>
      <th>
        <a href="index.jsp?action=1">ͼ��¼��</a>
      </th>
      <th>
        <a href="AdminBooksPageAction.do">ͼ�����</a>
      </th>
      <th>
        <a href="LendPageAction.do?page=1">�ѽ����</a>
      </th>
      <th>
        <a href="UsersPageAction.do?page=1">�û�����</a>
      </th>
       <th>
        <a href="PunishPageAction.do?page=1">����쿴</a>
      </th>
      <th>
        <a href="index.jsp?action=6">��������</a>
      </th>
      <th>
        <a href="AdminOutAction.do">�˳�</a>
      </th>
    </tr>
  </table>
  <table>
    <tbody>
      <c:if test="${param.action==1 or empty param.action}"><jsp:include flush="false" page="insertBook.jsp"/></c:if>
      <c:if test="${param.action==2}"><jsp:include flush="false" page="bookList.jsp"/></c:if>
      <c:if test="${param.action==3}"><jsp:include flush="false" page="lendlist.jsp"/></c:if>
      <c:if test="${param.action==4}"><jsp:include flush="false" page="userlist.jsp"/></c:if>
      <c:if test="${param.action==5}"><jsp:include flush="false" page="punishlist.jsp"/></c:if>
      <c:if test="${param.action==6}"><jsp:include flush="false" page="givebook.jsp"/></c:if>
      <c:if test="${param.action==7}"><jsp:include flush="false" page="testsList.jsp"/></c:if>
    </tbody>
  </table>
</center>
</body>
</html>
