<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="true" import="java.util.*, travel.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AFK_trable56 회원가입 test</title>
</head>
<body>
	<form name="registerOKForm" action="<c:url value='/action/home'/>"
		method="POST">
		<table width="700" height="700" align="center">
			<tr>
				<td width="250" align="center">아이디</td>
				<td><input type="text" name="id"> <a class="overlap"
					href="totalbest.html">중복확인</a></td>
			</tr>
			<tr>
				<td align="center">비밀번호</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td align="center">재확인</td>
				<td><input type="password" name="repass"></td>
			</tr>
			<tr>
				<td width="250" align="center">닉네임</td>
				<td><input type="text" name="nickname"> <a
					class="overlap" href="totalbest.html">중복확인</a></td>
			</tr>
			<tr>
				<td align="center">이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td align="center">성별</td>
				<td><input class="gender_man" name="gender" type="radio"
					value="man">남자&nbsp; <input class="gender_women"
					name="gender" type="radio" value="women">여자</td>
			</tr>

			<tr>
				<td align="center">이메일</td>
				<td><input type="text" name="email">
					&nbsp;&nbsp;@&nbsp;&nbsp; <select name="address">
						<option value="naver.com">naver.com</option>
						<option value="nate.com">nate.com</option>
						<option value="hanmail.net">hanmail.net</option>
						<option value="yahoo.co.kr">yahoo.co.kr</option>
						<option value="hotmail.com">hotmail.com</option>
				</select></td>
			</tr>
			<tr>
				<td align="center">생일</td>
				<td><input type="text" name="birth" size="8" maxlength="8">
					ex) 20150101</td>
			</tr>
			<tr height="80">
				<td colspan="2" align="center"><input type="submit" name="todo"
					value="회원가입"></td>
				</form>

			</tr>
		</table>
</body>
</html>