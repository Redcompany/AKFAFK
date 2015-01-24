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
.updateMember {
	background-color: #eee;
	font-size: 15px;
	font-weight: 450;
	font-family: fantasy;
}
input.form-control{
width: 300px;
}

</style>

<body>
<%@include file="always/top.jsp" %>
<div class="updateMember">
	<form name="UpdateMemberOK" action="<c:url value='/action/mypage'/>"
		method="POST">
		<table id='membershipChange' width="700" height="500" align="center">
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
				<td><input type="password" class="form-control" placeholder="현재 비밀번호"
					name="pass"></input></td>
			</tr>
			<tr>
				<td width="300" align="center">변경 비밀번호</td>
				<td><input type="password" class="form-control" placeholder="변경 비밀번호" name="rePass"></td>
			</tr>
			<tr>
				<td align="center">재확인</td>
				<td><input type="password" class="form-control" placeholder="재확인" name="reconPass"></td>
			</tr>
			<tr>
				<td align="center">이름</td>
				<td><input type="text" class="form-control" placeholder="이름" name="rename"></td>
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
				<td><input type="text" class="form-control" placeholder="휴대전화   	ex)010-xxxx-xxxx" name="changePhonenumber"></td>
			</tr>
			<tr>
				<td align="center">Email</td>
				<td><input type="text" class="form-control" placeholder="Email 		ex)xxxx@naver.com" name="changeMail"></td>
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
				<form name="checkoutForm" action="<c:url value='/action/mypage'/>"
						method="POST">
						<input class="cancel" type="submit" value="취 소">
					</form></td>
			</tr>

		</table>
		</div>
		<%@include file="always/bottom.jsp" %>
</body>
</html>