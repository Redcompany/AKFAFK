<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="true" import="java.util.*, travel.*, java.sql.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ID/PW 찾기</title>
<script>
	function findIDCheck() {
		if (document.FindIDOKForm.name.value == "") {
			alert("이름을 입력하세요");
			return false;
		} else if (document.FindIDOKForm.birth.value == "") {
			alert("생년월일을 입력하세요");
			return false;
		} else if (document.FindIDOKForm.nickname.value == "") {
			alert("닉네임이 입력하세요");
			return false;
		}
	}
	function findPWCheck() {
		if (document.FindPasswordOKForm.id.value == "") {
			alert("아이디를 입력하세요");
			return false;
		} else if (document.FindPasswordOKForm.name.value == "") {
			alert("이름을 입력하세요");
			return false;
		} else if (document.FindPasswordOKForm.birth.value == "") {
			alert("생년월일을 입력하세요.");
			return false;
		}
	}
</script>
</head>
<body>
<%@include file="always/top.jsp" %>
	<form name="FindIDOKForm" action="<c:url value='/action/home'/>"
		method="POST" onsubmit="return findIDCheck();">
		<table width="300" height="300" align="center">
			<tr>
				<td colspan="2" align="center">ID 찾기</td>
			</tr>
			<tr>
				<td align="center">이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td align="center">생년월일</td>
				<td><input type="text" name="birth"></td>
				<td>ex) 20150101</td>
			</tr>
			<tr>
				<td align="center">닉네임</td>
				<td><input type="text" name="nickname"></td>
				<td><input type="hidden" name="todo" value="ID찾기"></td>
			</tr>
			<tr height="80">
				<td colspan="2" align="center"><input type="submit"
					value="ID찾기"></input></td>
			</tr>

		</table>
	</form>

	<form name="FindPasswordOKForm" action="<c:url value='/action/home'/>"
		method="POST" onsubmit="return findPWCheck();">
		<table width="300" height="300" align="center">
			<tr>
				<td colspan="2" align="center">PW 찾기</td>
			</tr>
			<tr>
				<td align="center">아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td align="center">이름</td>
				<td><input type="text" name="name">
			</tr>
			<tr>
				<td align="center">생년월일</td>
				<td><input type="text" name="birth"></td>
				<td>ex) 20150101</td>
				<td><input type="hidden" name="todo" value="Password찾기"></td>
			</tr>
			<tr height="80">
				<td colspan="2" align="center"><input type="submit"
					value="Password찿기"></input></td>
			</tr>

		</table>
	</form>
	<%@include file="always/bottom.jsp" %>
</body>
</html>