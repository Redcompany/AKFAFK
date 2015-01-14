<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="true" import="java.util.*, travel.*, java.sql.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<script>
	function checking() {
		if (document.writeForm.id.value == "") {
			alert("아이디를 입력하세요");
			return false;
		} else if (document.writeForm.pass.value == "") {
			alert("패스워드를 입력하세요");
			return false;
		}else if (document.writeForm.pass.value != document.writeForm.repass.value){
			alert("패스워드가 일치하지않습니다.")
			return false;
		}else if (document.writeForm.name.value == ""){
			alert("이름을 입력하세요")
			return false;
		}else if (document.writeForm.birth.value == ""){
			alert("생년월일을 입력하세요")
			return false;
		}else if (document.writeForm.nickname.value == ""){
			alert("닉네임을 입력하세요")
			return false;
		}else if (document.writeForm.email.value == ""){
			alert("이메일을 입력하세요")
			return false;
		} else {
			document.writeForm.submit();
		return false;
		}
	}

	function checkid() {
		var cid = document.writeForm.id.value;
		if (cid == "")
			alert("입력된 아이디가 없습니다.")
		else
			window.open(
					"http://localhost:9999/TravelCommunity/action/checkID?id="
							+ cid, "", "whidth=400 height=150")
	}

	function checknickname() {
		var cnn = document.writeForm.nickname.value;
		if (cnn == "")
			alert("입력된 닉네임이 없습니다.")
		else
			window.open(
					"http://localhost:9999/TravelCommunity/action/checkNickName?nickname="
							+ cnn, "", "whidth=400 height=150")
	}
</script>
</head>
<body>
	<form name="writeForm" action="<c:url value='/action/home'/>"
		method="post" onsubmit="return checking();">
		<table border="2">
			<tr>
				<td colspan="2" align="center">회원가입</td>
			</tr>
			<tr>
				<td align="center">아이디</td>
				<td><input type="text" name="id" size="30"
					style="ime-mode: desabled"></input> <input type="button"
					value="중복확인" onclick="javascript:checkid()"></input></td>
			</tr>
			<tr>
				<td align="center">비밀번호</td>
				<td><input type="text" name="pass"></input></td>
			</tr>
			<tr>
				<td align="center">재확인</td>
				<td><input type="text" name="repass"></input></td>
			</tr>
			<tr>
				<td align="center">이름</td>
				<td><input type="text" name="name"></input></td>
			</tr>
			<tr>
				<td align="center">생년월일</td>
				<td><input type="text" name="birth"></input>ex)19910407</td>
			</tr>
			<tr>
				<td align="center">성별</td>
				<td><input class="gender_man" name="gender" type="radio"
					value="man">남자&nbsp; </input><input class="gender_women"
					name="gender" type="radio" value="women">여자</input></td>
			</tr>
			<tr>
				<td align="center">닉네임</td>
				<td><input type="text" name="nickname" size="30"
					style="ime-mode: desabled"></input> <input type="button"
					value="중복확인" onclick="javascript:checknickname()"></input></td>
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
				<input type="hidden" name="todo" value="회원가입"></input>
			</tr>
			<tr>
				<td colspan="2" align="center" ><input type="submit"
					value="회원가입" ></input></td>
			</tr>
		</table>
	</form>
</body>
</html>