<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty sessionScope.user}">
    <jsp:forward page="login.jsp"/>
</c:if>
<%
    request.getSession().setAttribute("url", request.getRequestURI());
%>
