<%@page import="com.AFK.travel56.dao.ArticleVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="true" import="java.util.*, com.AFK.travel56.dao.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title><%=request.getParameter("title") %></title>
</head>
<body>

	<table id="Articleboard" width="1000" height="65" align="center" border="1">
		<tr class="bestbackground">

			<th width="70">Number</th>
			<th width="300">제 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</th>
			<th width="100">I D</th>
			<th width="80">날 짜</th>
			<th width="80">추천수</th>
			<th width="80">조회수</th>

		</tr>
		
		<tr>
			<input type="hidden" name="cartIndex" value="listValue">
			<td><%=findArticle.getArticleNumber()%></td>
			<td>확인하자</td>
			<td>돈좀나와라</td>
			<td align="right">2015.01.01</td>
			<td align="right">7</td>
			<td align="right">10</td>
		</tr>

	</table>
	<br />

</body>
</html>