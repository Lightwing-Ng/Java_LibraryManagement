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
<center>
<h1>
以借图书
</h1>
<table border="1">
<tr>
<th>图书编号</th> <th>图书名字</th> <th>开始时间</th> <th>结束时间</th> <th>剩余天数</th><th>用户</th>
</tr>
<c:forEach var="booklend" items="${requestScope.list}">
<tr>
<td>${booklend.books_ID}</td> <td><b:booksname>${booklend.books_ID}</b:booksname></td> <td><script type="" language="javascript">printTime('${booklend.bookLend_StarTime}')</script></td> <td><script type="" language="javascript">printTime('${booklend.bookLend_EndTime}')</script></td> <td><date:datejian>${booklend.bookLend_EndTime}</date:datejian></td><td><u:getname>${booklend.users_ID}</u:getname></td>
</tr>
</c:forEach>
</table>
<table>
<tr>
<td><a href="LendPageAction.do?page=${requestScope.page-1<=0?"1":requestScope.page-1}">上一页</a></td><td><a href="LendPageAction.do?page=${requestScope.page+1>=requestScope.pagecount?requestScope.pagecount:requestScope.page+1}">下一页</a></td><td>${requestScope.page}/${requestScope.pagecount}页</td>
</tr>
</table>
</center>
</center>
