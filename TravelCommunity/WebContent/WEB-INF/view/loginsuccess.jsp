<%@page import="com.AFK.travel56.dao.MemberVO"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="true" import="java.util.*, travel.*"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
	<table align="center">
		<tr>
			<td>이름 :</td>
			<td>${sessionScope.loginsession.memberName}</td>

		</tr>
		<tr>
			<td colspan=2 align="center">님 <b>환영합니다.</b>

			</td>
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
			<td colspan=2></td>
		</tr>
		<tr>
			<td colspan=2><input type="button"
				onclick="location.href = '/MySing/action/loginform'" value="로그아웃"></td>
		</tr>
		<tr>
			<td colspan=2><input type="button"
				onclick="location.href = '/${initParam.context_root }/GetMemberInfo'"
				value="My Page"></td>
		</tr>

	</table>
</body>
</html>
