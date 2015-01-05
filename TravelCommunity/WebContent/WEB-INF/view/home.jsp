<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html lange="ko">
<head>
<meta charset="UTF-8">
<title>AFK_trable56에 온 것을 환영해요~</title>
</head>
<body>
	<style>
#Table td {
	background-color: white;
	font-family: sans-serif;
	text-align: center;
}
</style>

	<form name="checkoutForm"
		action="<c:url value='/action/showArticles'/>" method="POST">
		<input type="checkbox" name="continent" value="유럽">유럽 <input
			type="submit" value="Checkout">
	</form>
	<a class="asd" href="register" id="회원가입">회원가입</a>
	<a class="asd" href="loginMember" id="회원가입">로그인</a>
	<table boder="1" width="1050" height="800" align="center">
		<tr>
			<td>
				<table class="totalbest" width="500" height="130" cellpadding="0"
					cellspacing="1" boder="0" id="Table">

					<th class="totalbest" colspan=2>전체 BEST</th>

					<tr class="bestbackground">
						<th width="70">Number</th>
						<th width="300">제 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</th>
						<th width="100">I D</th>
						<th width="80">날 짜</th>
						<th width="80">추천수</th>
					</tr>
					<tr>

						<td>1</td>
						<td>내용</td>
						<td>두부외상</td>
						<td>12-16</td>
						<td>1004</td>
					</tr>
					<tr>
						<td>2</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>3</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>4</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>5</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</table>
			</td>
			<td width="50%">
				<table width="500" height="130" cellpadding="0" cellspacing="1"
					boder="0" id="Table">
					<th class="totalbest" colspan=2>공지사항</th>
					<tr class="bestbackground">
						<th width="70">Number</th>
						<th width="300">제 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</th>
						<th width="100">I D</th>
						<th width="80">날 짜</th>
						<th width="80">추천수</th>
					</tr>
					<tr>

						<td>1</td>
						<td>내용</td>
						<td>두부외상</td>
						<td>12-16</td>
						<td>1004</td>
					</tr>
					<tr>
						<td>2</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>3</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>4</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>5</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td width="50%">
				<table width="500" height="130" cellpadding="0" cellspacing="1"
					boder="0" id="Table" align="center">

					<th class="totalbest" colspan=2>유럽 BEST</th>

					<tr class="bestbackground">
						<th width="70">Number</th>
						<th width="300">제 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</th>
						<th width="100">I D</th>
						<th width="80">날 짜</th>
						<th width="80">추천수</th>
					</tr>
					<tr>

						<td>1</td>
						<td>내용</td>
						<td>두부외상</td>
						<td>12-16</td>
						<td>1004</td>
					</tr>
					<tr>
						<td>2</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>3</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>4</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>5</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</table>
			</td>
			<td width="50%">
				<table width="500" height="130" cellpadding="0" cellspacing="1"
					boder="0" id="Table" align="center">

					<th class="totalbest" colspan=2>아시아 BEST</th>

					<tr class="bestbackground">
						<th width="70">Number</th>
						<th width="300">제 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</th>
						<th width="100">I D</th>
						<th width="80">날 짜</th>
						<th width="80">추천수</th>
					</tr>
					<tr>

						<td>1</td>
						<td>내용</td>
						<td>두부외상</td>
						<td>12-16</td>
						<td>1004</td>
					</tr>
					<tr>
						<td>2</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>3</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>4</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>5</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td width="50%">
				<table width="500" height="130" cellpadding="0" cellspacing="1"
					boder="0" id="Table" align="center">

					<th class="totalbest" colspan=2>아프리카 BEST</th>

					<tr class="bestbackground">
						<th width="70">Number</th>
						<th width="300">제 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</th>
						<th width="100">I D</th>
						<th width="80">날 짜</th>
						<th width="80">추천수</th>
					</tr>
					<tr>

						<td>1</td>
						<td>내용</td>
						<td>두부외상</td>
						<td>12-16</td>
						<td>1004</td>
					</tr>
					<tr>
						<td>2</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>3</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>4</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>5</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</table>
			</td>
			<td width="50%">
				<table width="500" height="130" cellpadding="0" cellspacing="1"
					boder="0" id="Table" align="center">

					<th class="totalbest" colspan=2>북아메리카 BEST</th>

					<tr class="bestbackground">
						<th width="70">Number</th>
						<th width="300">제 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</th>
						<th width="100">I D</th>
						<th width="80">날 짜</th>
						<th width="80">추천수</th>
					</tr>
					<tr>

						<td>1</td>
						<td>내용</td>
						<td>두부외상</td>
						<td>12-16</td>
						<td>1004</td>
					</tr>
					<tr>
						<td>2</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>3</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>4</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>5</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td width="50%">
				<table width="500" height="130" cellpadding="0" cellspacing="1"
					boder="0" id="Table" align="center">

					<th class="totalbest" colspan=2>남아메리카 BEST</th>

					<tr class="bestbackground">
						<th width="70">Number</th>
						<th width="300">제 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</th>
						<th width="100">I D</th>
						<th width="80">날 짜</th>
						<th width="80">추천수</th>
					</tr>
					<tr>

						<td>1</td>
						<td>내용</td>
						<td>두부외상</td>
						<td>12-16</td>
						<td>1004</td>
					</tr>
					<tr>
						<td>2</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>3</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>4</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>5</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</table>
			</td>
			<td width="50%">
				<table width="500" height="130" cellpadding="0" cellspacing="1"
					boder="0" id="Table" align="center">

					<th class="totalbest" colspan=2>오세아니아 BEST</th>

					<tr class="bestbackground">
						<th width="70">Number</th>
						<th width="300">제 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</th>
						<th width="100">I D</th>
						<th width="80">날 짜</th>
						<th width="80">추천수</th>
					</tr>
					<tr>

						<td>1</td>
						<td>내용</td>
						<td>두부외상</td>
						<td>12-16</td>
						<td>1004</td>
					</tr>
					<tr>
						<td>2</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>3</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>4</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>5</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

</body>
</html>