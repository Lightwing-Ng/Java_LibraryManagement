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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tags/bookname.tld" prefix="b" %>
<%@ taglib uri="/WEB-INF/tags/datectrl.tld" prefix="date" %>
<%@ taglib uri="/WEB-INF/tags/username.tld" prefix="u" %>
${requestScope.DeletePunishMsg}
<center>
<h1>
查看罚单
</h1>
<table border="1">
<tr>
<th>用户ID</th> <th>用户名字</th> <th>所借图书</th> <th>晚还天数</th> <th>处罚金额</th><th>操作</th>
</tr>
<c:forEach var="punish" items="${requestScope.list}">
<tr>
<td>${punish.users_ID}</td> <td><u:getname>${punish.users_ID}</u:getname></td> <td><b:booksname>${punish.books_ID}</b:booksname></td> <td>${punish.punish_Day}</td> <td>${punish.punish_Money}</td><td><a href="DeletePunishAction.do?punish_ID=${punish.punish_ID}">付款</a></td>
</tr>
</c:forEach>
</table>
<table>
<tr>
<td><a href="PunishPageAction.do?page=${requestScope.page-1<=0?"1":requestScope.page-1}">上一页</a></td><td><a href="PunishPageAction.do?page=${requestScope.page+1>=requestScope.pagecount?requestScope.pagecount:requestScope.page+1}">下一页</a></td><td>${requestScope.page}/${requestScope.pagecount}页</td>
</tr>
</table>
</center>
