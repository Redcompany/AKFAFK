<%@page import="com.AFK.travel56.dao.ArticleVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="true" import="java.util.*, com.AFK.travel56.dao.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>클릭한 제목을 보여줘~</title>
</head>
<body>
	<style>
td {
	background-color: white;
	font-family: sans-serif;
	text-align: center;
}
</style>
	<table id="Articleboard" width="1000" height="500" align="center">
		<tr class="bestbackground">

			<th width="70">Number</th>
			<th width="300">제 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</th>
			<th width="100">I D</th>
			<th width="80">날 짜</th>
			<th width="80">추천수</th>

		</tr>
		<%
			ArticleVO theArticles = (ArticleVO) session
					.getAttribute("articleNumber");
		%>
		<tr>
			<input type="hidden" name="cartIndex"
				value="<%=theArticles.getMemberNumber()%>">
			<td>"<%=theArticles.getArticleNumber()%></td>
			<td><%=theArticles.getArticleTitle()%></td>
			<td><%=theArticles.getMemberNickName()%></td>
			<td align="right"><%=theArticles.getArticleRecommendCount()%></td>
			<td align="right"><%=theArticles.getArticleViewCount()%></td>


		</tr>

	</table>
	<br />

</body>
</html>