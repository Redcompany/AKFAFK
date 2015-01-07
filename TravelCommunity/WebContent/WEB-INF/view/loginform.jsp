<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page session="true" import="java.util.*, travel.*" %>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form name="login" action="<core:url value='/action/loginsuccess'/>" method="POST">
        <table>
            <tr>
                <td>아이디</td>
                <td><input type="text" name=id></td>
                <td rowspan=2><input type=submit name="todo" value="login"></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name=password></td>
            </tr>
            <p>${sessionScope.loginsession.memberName}</p>
        	 <tr>
                <td><b> <core:if
                            test="${!empty requestScope.loginfailuremessage }"><font color="RED">${requestScope.loginfailuremessage }</font></core:if>
                </b></td>
            </tr>
        </table>
    </form>
</body>
</html>
