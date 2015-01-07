<%@page import="com.AFK.travel56.dao.ArticleVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="true" import="java.util.*, com.AFK.travel56.dao.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title><%=request.getParameter("getArticleTitle")%></title>
</head>
<body>

	<table id="Articleboard" width="1500" height="65" align="center"
		border="1">
		<tr class="bestbackground">

			<th width="50">Number</th>
			<th width="150">대륙</th>
			<th width="150">나라</th>
			<th width="370">제 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</th>
			<th width="200">I D</th>
			<th width="100">날 짜</th>
			<th width="80">추천수</th>
			<th width="80">조회수</th>

		</tr>

		<%
			ArticleVO readArticle = (ArticleVO) session
					.getAttribute("Articles");
			if (readArticle != null) {
		%>

		<tr align="center">
			<input type="hidden" name="cartIndex" value="listValue">
			<td><%=readArticle.getArticleNumber()%></td>
			<td><%=readArticle.getArticleContinent()%></td>
			<td><%=readArticle.getArticleCountry()%></td>
			<td><%=readArticle.getArticleTitle()%></td>
			<td><%=readArticle.getMemberNickName()%>
			<td align="right"><%=readArticle.getArticleDate()%></td>
			<td align="right"><%=readArticle.getArticleRecommendCount()%></td>
			<td align="right"><%=readArticle.getArticleViewCount() %></td>
		</tr>

		<tr>
			<td colspan="8"></td>
		</tr>

		<tr align="center">
			<td colspan="8"><%=readArticle.getArticleContent()%></td>
		</tr>

		<tr align="center">
			<td colspan="5"></td>
			<td colspan="3">
				<input type=button value="수정">
				<input type=button value="삭제">
				<input type=button value="답글">
				<input type=button value="추천">
				<input type=button value="목록" OnClick="showArticles.jsp">
				
			</td>
		</tr>

	</table>
	<br />
	<%
		}
	%>

</body>
</html>