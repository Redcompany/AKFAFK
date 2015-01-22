<%@page import="com.AFK.travel56.dao.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="true" import="java.util.*, travel.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<title>회원정보변경</title>
<meta charset="UTF-8">
</head>
<style>
#dropdown-menu h2 {
	padding: 14px;
	margin: 0;
	font-size: 16px;
	font-weight: 400;
}

#dropdown-menu .sample {
	width: 200px;
}

#dropdown-menu .form-control-wrapper {
	margin: 30px 0;
}
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
<%@include file="always/top.jsp" %>
	<form name="UpdateMemberOK" action="<c:url value='/action/mypage'/>"
		method="POST">
		<table id='membershipChange' width="700" height="700" align="center">
			<tr>
				<td class="membership" colspan="2" align="center">회원정보변경</td>
			</tr>
			<tr>
				<td width="300" align="center">회원번호</td>
				<td>${sessionScope.loginsession.memberNumber}</td>
			</tr>
			<td width="300" align="center">아이디</td>
			<td>${sessionScope.loginsession.memberID}</td>
			<tr>
				<td width="300" align="center">현재 비밀번호</td>
				<td><input type="text" name="Pass"></td>
			</tr>
			<tr>
				<td width="300" align="center">변경 비밀번호</td>
				<td><input type="text" name="rePass"></td>
			</tr>
			<tr>
				<td align="center">재확인</td>
				<td><input type="text" name="reconPass"></td>
			</tr>
			<tr>
				<td align="center">이름</td>
				<td><input type="text" name="rename"></td>
			</tr>
			<tr>
				<td align="center">성별</td>
				<%
					MemberVO findMemeber = (MemberVO) session
							.getAttribute("loginsession");
					if (findMemeber.isMemberGender()) {
				%>
				<td>남자</td>
				<%
					} else {
				%>
				<td>여자</td>
				<%
					}
				%>
			</tr>
			<tr>
				<td align="center">휴대전화</td>
				<td><input type="text" name="changePhonenumber"></td>
			</tr>
			<tr>
				<td align="center">eMail</td>
				<td><input type="text" name="changeMail"></td>
			</tr>
			<tr>
				<td align="center">생년월일</td>
				<td>${sessionScope.loginsession.memberBirth}</td>
			</tr>
			<tr>
				<td align="center">닉네임</td>
				<td>${sessionScope.loginsession.memberNickName}</td>
			</tr>
			<tr height="80">
				<td colspan="3" align="center"><input type="submit" value="저 장">
					</form>
					<form name="checkoutForm" action="<c:url value='/action/mypage'/>"
						method="POST">
						<input class="cancel" type="submit" value="취 소">
					</form></td>
			</tr>

		</table>
		<%@include file="always/bottom.jsp" %>
</body>
</html>