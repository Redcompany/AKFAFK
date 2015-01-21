<%@page import="com.AFK.travel56.dao.MemberVO"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
</head>
<body>
	<%@include file="always/top.jsp"%>
		<table align="center">
			<tr>
				<td>회원 번호 :</td>
				<td colspan="2">${sessionScope.loginsession.memberNumber}</td>
			</tr>
			<tr>
				<td>아이디 :</td>
				<td colspan="2">${sessionScope.loginsession.memberID}</td>
			</tr>
			<tr>
				<td>이 름 :</td>
				<td colspan="2">${sessionScope.loginsession.memberName}</td>
			</tr>
			<tr>
				<td>성 별 :</td>
				<%
					MemberVO findMemeber = (MemberVO) session
							.getAttribute("loginsession");
					if (findMemeber.isMemberGender()) {
				%>
				<td colspan="2">남자</td>
				<%
					} else {
				%>
				<td colspan="2">여자</td>
				<%
					}
				%>
			</tr>
			<tr>
				<td>이메일 :</td>
				<td colspan="2">${sessionScope.loginsession.memberEmail}</td>
			</tr>
			<tr>
				<td>핸드폰 번호 :</td>
				<td colspan="2">${sessionScope.loginsession.memberPhone}</td>
			</tr>
			<tr>
				<td>생년월일 :</td>
				<td colspan="2">${sessionScope.loginsession.memberBirth}</td>
			</tr>
			<tr>
				<td>닉네임 :</td>
				<td colspan="2">${sessionScope.loginsession.memberNickName}</td>
			</tr>
			<tr>
				<td align="center">
					<form name="ok" action="<c:url value='/action/home'/>"
						method="POST">
						<input class="ok" type="submit" name="todo" value="확인">
					</form>
				</td>
				<td>
					<form name="updateMember"
						action="<c:url value='/action/updateMember'/>" method="POST">
						<input class="update" type="submit" value="회원 정보 수정">
					</form>
				</td>
				<td>
					<form name="deleteMember" action="<c:url value='/action/home'/>"
						method="POST">
						<input class="delete" type="submit" name="todo" value="탈퇴">
					</form>
				</td>
			</tr>
		</table>
	<%@include file="always/bottom.jsp"%>
</body>
</html>