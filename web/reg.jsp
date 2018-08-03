<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html:html>
    <head>
        <title>
            <bean:message key="jsp.user.reg.title"/>
        </title>
    </head>
    <body bgcolor="#ffffff">
    <center>
        <h1>
            <bean:message key="jsp.user.reg.title"/>
        </h1>
        <html:form action="UsersRegAction.do" method="post">
            <table>
                <tr>
                    <td><bean:message key="jsp.user.reg.name"/></td>
                    <td><html:text property="users_Name"/><font color="red"><html:errors
                            property="nameerr"/></font></td>
                </tr>
                <tr>
                    <td><bean:message key="jsp.user.reg.pwd"/></td>
                    <td><html:password property="users_Pwd"/><font color="red"><html:errors
                            property="pwderr"/></font></td>
                </tr>
                <tr>
                    <td><bean:message key="jsp.user.reg.pwd1"/></td>
                    <td><html:password property="users_Pwd1"/><font color="red"><html:errors
                            property="pwd1err"/><html:errors property="pwd2err"/></font></td>
                </tr>
                <tr>
                    <td><bean:message key="jsp.user.reg.sex"/></td>
                    <td><html:radio value="1" property="users_Sex"/><bean:message
                            key="jsp.user.reg.sex.b"/><html:radio value="0"
                                                                  property="users_Sex"/><bean:message
                            key="jsp.user.reg.sex.g"/><font color="red"><html:errors
                            property="sexerr"/></font></td>
                </tr>
                <tr>
                    <td><bean:message key="jsp.user.reg.phone"/></td>
                    <td><html:text property="users_Phone"/><font color="red"><html:errors
                            property="phoneerr"/></font></td>
                </tr>
                <tr>
                    <td><bean:message key="jsp.user.reg.class"/></td>
                    <td>
                        <html:select property="user_n">
                            <c:forEach var="item" begin="1" end="4">
                                <html:option value="${item}">${item}</html:option>
                                <bean:message key="jsp.user.reg.class.n"/>
                            </c:forEach>
                        </html:select><bean:message key="jsp.user.reg.class.n"/>

                        <html:select property="user_b">
                            <c:forEach var="item" begin="1" end="10">
                                <html:option value="${item}">${item}</html:option>
                                <bean:message key="jsp.user.reg.class.b"/>
                            </c:forEach>
                        </html:select><bean:message key="jsp.user.reg.class.b"/>
                        &nbsp;<font color="red"><html:errors property="classerr"/></font></td>
                </tr>
                <tr>
                    <td><bean:message key="jsp.user.reg.adds"/></td>
                    <td><html:text property="users_Adds"/><font color="red"><html:errors
                            property="addserr"/></font></td>
                </tr>
                <tr>
                    <td><html:submit><bean:message key="jsp.user.reg.regbut"/></html:submit>
                        <html:reset><bean:message key="jsp.user.reg.regre"/></html:reset></td>
                    <td></td>
                </tr>
            </table>
        </html:form>
    </center>
    </body>
</html:html>
