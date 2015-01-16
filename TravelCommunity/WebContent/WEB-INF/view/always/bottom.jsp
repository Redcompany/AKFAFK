<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br/>
	<table align="center" >
		<tr>
			<%
				String logoB = request.getContextPath() + "/test/지도.jpg";
			%>

			<td width="100"> <img class="bottom_img" src=<%=logoB%> width='80%' height='auto'>
			</td>
			
			<td>
			<span class="noticeBottom">| 공지사항 | 회원이용약관 | 개인정보보호방침 | 문의	사항 |</span>
			<p> <span class="adress" style="font-size: x-small;">서울시 중구 초동 	106 - 9번지 솔로몬빌딩 501호 맨 뒷자리 | 사업자등록번호 000-00-00000 | (주) 백절불굴 대표 XXX
				</span><br/>
			</p>

			<p> <span class="phone_num" style="font-size: x-small;">BackJuyl
					Project 106 - 9 Cho-dong, Jung-gu, Seoul, 100-300 Rep. of KOREA. 문의 전화 : 5656 - 1818, FAX : 1828 - 1828</span><br/>
			</p>
			</td>
		</tr>
	</table>
</body>
</html>

