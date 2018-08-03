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
<%@page contentType="text/html; charset=GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include flush="false" page="isLogin.jsp"/>
<html>
<head>
<title>Admin管理</title>
<script type="" language="javascript" src="js/public.js"></script>
</head>
<body bgcolor="#ffffff">
<center>
  <table>
    <tr>
      <th>
        <a href="index.jsp?action=1">图书录入</a>
      </th>
      <th>
        <a href="AdminBooksPageAction.do">图书馆里</a>
      </th>
      <th>
        <a href="LendPageAction.do?page=1">已借出书</a>
      </th>
      <th>
        <a href="UsersPageAction.do?page=1">用户管理</a>
      </th>
       <th>
        <a href="PunishPageAction.do?page=1">罚款单察看</a>
      </th>
      <th>
        <a href="index.jsp?action=6">返还操作</a>
      </th>
      <th>
        <a href="AdminOutAction.do">退出</a>
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
