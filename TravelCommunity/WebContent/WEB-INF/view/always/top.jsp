<%@page import="com.AFK.travel56.dao.MemberVO"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<!-- <script src="http://code.jquery.com/jquery-1.7.2.min.js"></script>-->
<script>
	$(document).ready(function() {
		$(".login").click(function() {
			$(".id").hide();
			$(".pass").hide();
			$(".login").hide();
			function load() {
				$.ajax({
					type : "POST",
					url : "/action/loginsuccess",
					success : function(responseText) {
						$('.loginsuccess').text(responseText)
					}
				})
			}
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<table align="center" width="1000px">
	<tr>
		<%
			String logo = request.getContextPath() + "/test/지도.jpg";
		%>
		<td align="center"><a class="minimap"> <img src=<%=logo%>
				width='40%' height='auto'>
		</a></td>
		<td><select class="eu" name="유럽"
			style="width: 100px; height: 40px">
				<option>유럽</option>
				<option>영국</option>
				<option>이탈리아</option>
		</select></td>

		<td><select class="asia" name="아시아"
			style="width: 100px; height: 40px">
				<option>아시아</option>
				<option>중국</option>
				<option>한국</option>
		</select></td>

		<td><select class="africa" name="아프리카"
			style="width: 100px; height: 40px">
				<option>아프리카</option>
				<option>소말리아</option>
				<option>뉴기니</option>
		</select></td>

		<td><select class="namerica" name="북아메리카"
			style="width: 100px; height: 40px">
				<option>북아메리카</option>
				<option>미국</option>
				<option>캐나다</option>
		</select></td>
		<td><select class="samerica" name="남아메리카"
			style="width: 100px; height: 40px">
				<option>남아메리카</option>
				<option>브라질</option>
				<option>아르헨티나</option>
		</select></td>

		<td><select class="oceania" name="오세아니아"
			style="width: 100px; height: 40px">
				<option>오세아니아</option>
				<option>호주</option>
				<option>뉴질랜드</option>
		</select></td>

		<td><table bgcolor="white" align="left">
				<tr>
					<th><input class="id" type="text" size="10" maxlength="12"
						placeholder="아이디"><br> <input class="pass"
						type="password" size="10" maxlength="12" placeholder="비밀번호"></th>


					<th><input class="login" type="submit" name="todo" value="로그인"
						style="width: 70px; height: 30px;"
						onclick="if(frm.id.value == ''){frm.id.focus(); return false;}" /><br></th>
				</tr>
				<tr>
					<td colspan="2"><a class="join" href="register" id="회원가입">회원가입</a>
						<a class="find" href="findIDPassword" id="찾기">ID/PW 찾기</a></td>
				</tr>
			</table></td>
</table>
</body>
</html>