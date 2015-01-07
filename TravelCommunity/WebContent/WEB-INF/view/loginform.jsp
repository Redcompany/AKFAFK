<!--<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="true" import="java.util.*, travel.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<link http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 로그인 폼</title>
</head>

<body>
<form action="<c:url value='/action/loginProc'/>" method="post">
<table>
<tr><th>아이디</th><td><input type="text" name="id"></td></tr>
<tr><th>비밀번호</th><td><input type="password" name="pass"></td></tr>
<tr><td colspan="2"><input type="submit" value="로그인"></td></tr>
</table>
</form>-->
	<!--  <table id='membershipChange' width="700" height="700" align="center">
		<tr>
			<td class="membership" colspan="2" align="center">로그인</td>
		</tr>
		<form name="UpdateMemberOKForm"
			action="<c:url value='/action/updateMember'/>" method="POST">
			<tr>
				<td width="300" align="center">ID</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td align="center">비밀번호</td>
				<td><input type="text" name="pass"></td>
			</tr>
			<tr height="80">
				<td colspan="3" align="center"><input class="rename"
					type="submit" value="로그인">
		</form>
		<form name="checkoutForm" action="<c:url value='/action/home'/>"
			method="POST">
			<input class="cancel" type="submit" value="취소">
		</form>
		</tr>
	</table>

</body>
</html>
-->

<!--  <h1>로그인</h1>
<form action="<c:url value='/action/loginPro'/>" method="post">
아이디: <input type="text" name="id"><br>
패스워드: <input type="password" name="passwd"><br>
<input type="submit" value="로그인"><br>
</form>-->
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
        	 <tr>
                <td><b> <core:if
                            test="${!empty requestScope.loginfailuremessage }"><font color="RED">${requestScope.loginfailuremessage }</font></core:if>
                </b></td>
            </tr>
        </table>
    </form>
</body>
</html>
