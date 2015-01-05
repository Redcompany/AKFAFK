<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="true" import="java.util.*, travel.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AFK_trable56 ID/PW 찾기</title>
</head>
<body>
	<form name="FindIDPasswordOKForm"
		action="<c:url value='/action/home'/>" method="POST">
		<table width="300" height="300" align="center">
			<tr>
				<td align="center">이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td align="center">생일</td>
				<td><input type="text" name="birth"></td>
					<td>ex) 20150101</td>
			</tr>
			<tr>
				<td align="center">닉네임</td>
				<td><input type="text" name="nickname"></td>
			</tr><tr height="80">
				<td colspan="2" align="center"><input type="submit" name="todo"
					value="ID찾기"></td>
				</form>
	<form name="FindIDPasswordOKForm"
		action="<c:url value='/action/home'/>" method="POST">
		<table width="300" height="300" align="center">
			<tr>
				<td align="center">아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td align="center">이름</td>
				<td><input type="text" name="name">
			</tr>
			<tr>
				<td align="center">생일</td>
				<td><input type="text" name="birth"></td>
					<td>ex) 20150101</td>
			</tr><tr height="80">
				<td colspan="2" align="center"><input type="submit" name="todo"
					value="Password찿기"></td>
				</form>
</body>
</html>