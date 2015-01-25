<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BOTTOM</title>
<link rel="stylesheet" type="text/css"
	href="http://localhost:9999/TravelCommunity/css/styles.css">
<style>
.noticeBottom {
	margin-left: 40px;
}
</style>
</head>
<body>
	<br />
	<table align="center">
		<tr>
			<%
				String logoB = request.getContextPath() + "/devImg/map.jpg";
			%>

			<td align="center" width="100"><img src=<%=logoB%> width='80%'
				height='auto'></td>

			<td><span class="noticeBottom"> | <a
					href="<c:url value='/action/showArticle/?todo=doing&continent=공지'/>">공지사항</a>
					| <a href="#">회원이용약관 </a> | <a href="#">개인정보보호방침</a> | <a href="#">문의
						사항</a> |
			</span>
				<p>
					<span class="infoAdress">서울시 중구 초동 106 - 9번지 솔로몬빌딩 501호 제일
						앞자리 | 사업자등록번호 000-00-00000 | (주) 백절불굴 대표 XXX </span><br />
				</p>

				<p>
					<span class="infoAdress">AFK Project 106 - 9 Cho-dong,
						Jung-gu, Seoul, 100-300 Rep. of KOREA. 문의 전화 : 5656 - 5656, FAX :
						5656 - 5656</span><br />
				</p></td>
		</tr>
	</table>
</body>
</html>

