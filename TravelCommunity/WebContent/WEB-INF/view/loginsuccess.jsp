<%@page import="com.AFK.travel56.dao.MemberVO"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
	<form class="loginsuccess">
	<table align="center" >
	<form id = "success">
		<tr>
			<td>이름 :</td>
			<td>${sessionScope.loginsession.memberName}</td>

		</tr>
		<tr>
			<td colspan=2 align="center">님 <b>환영합니다.</b>

			</td>
		</tr>
		</form>
		<tr>
			<td colspan=2></td>
		</tr>
		<tr>
			<td colspan=2></td>
		</tr>
		<tr>
			<td colspan=2></td>
		</tr>
		<tr>
			<td colspan=2></td>
		</tr>
		<tr>
		<form name="logout" action="<c:url value='/action/home'/>"
						method="POST">
						<input class="logout" type="submit" name="todo" value="로그아웃">
					</form>
		</tr>
		<tr>
		<form name="MyPage" action="<c:url value='/action/mypage'/>"
						method="POST">
						<input class="logout" type="submit" value="My Page">
					</form>
		</tr>

	</table>
	</form>
</body>
</html>

