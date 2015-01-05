<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="true" import="java.util.*, travel.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<title>회원로그인</title>
<meta charset="UTF-8">
</head>
<style>
td {
	background-color: white;
	font-size: 30px;
	font-weight: 900;
	font-family: fantasy;
}

input {
	border-radius: 4px 4px 4px 4px;
	width: 250px;
	height: 30px;
}
</style>

<body>
	<table id='membershipChange' width="700" height="700" align="center">
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