<%@page import="com.AFK.travel56.dao.ArticleVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="true" import="java.util.*, com.AFK.travel56.dao.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>대륙게시판입니다.</title>
</head>
<body>
<%@include file="always/top.jsp" %>
	<p>
		<strong>대륙게시판</strong>
	</p>
	<table border="1" cellspacing="0" cellpadding="5">
		<tr>
			<th>No.</th>
			<th>제목</th>
			<th>작성자</th>
			<th>추천수</th>
			<th>조회수</th>
		</tr>

		<c:forEach var="Articles" items="${Articles}">

			<tr>
				<input type="hidden" name="todo" value="remove">
				<input type="hidden" name="cartIndex"
					value="${Articles.memberNumber}">
				<td>${Articles.articleNumber}</td>
				<td><a
					href="readArticle?todo=read&idx=${Articles.articleNumber}">${Articles.articleTitle}</a></td>
				<td>${Articles.memberNickName}</td>
				<td align="right">${Articles.articleRecommendCount}</td>
				<td align="right">${Articles.articleViewCount}</td>
			</tr>
			
		</c:forEach>

	</table>
	<br />
	<a class="homeList" href="home">목록</a>
	<%@include file="always/bottom.jsp" %>
</body>
</html>