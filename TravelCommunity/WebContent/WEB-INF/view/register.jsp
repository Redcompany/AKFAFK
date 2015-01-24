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
		} else if (document.writeForm.pass.value != document.writeForm.repass.value) {
			alert("패스워드가 일치하지않습니다.")
			return false;
		} else if (document.writeForm.name.value == "") {
			alert("이름을 입력하세요")
			return false;
		} else if (document.writeForm.birth.value == "") {
			alert("생년월일을 입력하세요")
			return false;
		} else if (document.writeForm.nickname.value == "") {
			alert("닉네임을 입력하세요")
			return false;
		} else if (document.writeForm.email.value == "") {
			alert("이메일을 입력하세요")
			return false;
		} else {
			document.writeForm.submit()
			{
				alert("가입을 환엽합니다")
			}
			return false;
		}
	}
	function checkid() {
		var cid = document.writeForm.id.value;

		if (cid == "") {
			alert("입력된 아이디가 없습니다.")
		} else {
			window.open(
					"http://localhost:9999/TravelCommunity/action/checkID?id="
							+ cid, "",
					"left=300, top=200, width=200, height=200")
		}
	}

	function checknickname() {
		var cnn = document.writeForm.nickname.value;
		if (cnn == "")
			alert("입력된 닉네임이 없습니다.")
		else
			window.open(
					"http://localhost:9999/TravelCommunity/action/checkNickName?nickname="
							+ cnn, "",
					"top=200, left=100, width=200, height=200")
	}
</script>
</head>
<body>
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
</style>

	<%@include file="always/top.jsp"%>
	<form name="writeForm" action="<c:url value='/action/home'/>"
		method="post" onsubmit="return checking();">
		<table border="2" align="center">
			<div class="inputs">
				<tr>
					<td colspan="2" align="center">회원가입</td>
				</tr>

				<tr>
					<td align="center">아이디</td>
					<td><input type="text" class="form-control" placeholder="아이디"
						name="id" size="30" style="ime-mode: desabled"></input> <input
						type="button" value="중복확인" onclick="javascript:checkid()"></input></td>
				</tr>
				<tr>
					<td align="center">비밀번호</td>
					<td><input type="password" class="form-control"
						placeholder="비밀번호" name="pass"></input></td>
				</tr>
				<tr>
					<td align="center">재확인</td>
					<td><input type="password" class="form-control"
						placeholder="재확인" name="repass"></input></td>
				</tr>
				<tr>
					<td align="center">이름</td>
					<td><input type="text" class="form-control" placeholder="이름"
						name="name"></input></td>
				</tr>
				<tr>
					<td align="center">생년월일</td>
					<td><input type="text" class="form-control" placeholder="생년월일"
						name="birth"></input>ex)19910407</td>
				</tr>
			</div>

			<tr>
				<td align="center">성별</td>
				<td><div class="sample1">
						<div class="radio radio-success">
							<label> <input type="radio" class="gender_man"
								name="gender" value="man" checked=""> 남자
							</label>
						</div>
						<div class="radio radio-success">
							<label> <input type="radio" class="gender_women"
								name="gender" value="women"> 여자
							</label>
						</div>
					</div></td>
			</tr>
			<div class="inputs">
				<tr>
					<td align="center">닉네임</td>
					<td><input type="text" class="form-control" placeholder="닉네임"
						name="nickname" size="30" style="ime-mode: desabled"></input> <input
						type="button" value="중복확인" onclick="javascript:checknickname()"></input></td>
				</tr>
				<tr>
					<td align="center">이메일</td>
					<td><input type="text" name="email" class="form-control"
						placeholder="이메일"> &nbsp;&nbsp;@&nbsp;&nbsp;
						<div class="sample">
							<select name="address" class="form-control" placeholder="선택하세요">
								<option value="naver.com">naver.com</option>
								<option value="nate.com">nate.com</option>
								<option value="hanmail.net">hanmail.net</option>
								<option value="yahoo.co.kr">yahoo.co.kr</option>
								<option value="hotmail.com">hotmail.com</option>
							</select>
						</div></<input></td>
					<input type="hidden" name="todo" value="회원가입"></input>
				</tr>
			</div>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="회원가입"></input></td>
			</tr>
		</table>
	</form>
	<%@include file="always/bottom.jsp"%>
</body>
</html>