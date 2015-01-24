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
<link rel="stylesheet" type="text/css"
	href="http://localhost:9999/TravelCommunity/dist/css/material.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet">
<link href="css/ripples.min.css" rel="stylesheet">
<link href="css/material-wfont.min.css" rel="stylesheet">
<link href="css/styles/css" rel="stylesheet">

</head>
<body>

	<%@include file="always/top.jsp"%>
	<center>
		<H2>
			<%
				if (request.getAttribute("continent") != null) {
			%>
			<strong><%=request.getAttribute("continent")%> 게시판</strong>
			<%
				} else {
					if (request.getParameter("country") == null) {
			%>
			<strong><%=request.getParameter("continent")%> 게시판</strong>
			<%
				} else {
			%>
			<strong><%=request.getParameter("country")%> 게시판</strong>
			<%
				}
			}
			%>
		</H2>
	</center>

	<table class="table table-striped table-hover">
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
				<td>${Articles.articleRecommendCount}</td>
				<td>${Articles.articleViewCount}</td>
			</tr>
		</c:forEach>
	</table>

	<table width="87.5%">
		<tr>
			<td align="right"><a href="createArticle"><input
					type="button" value="글등록"></a> <a href="home">
		</tr>
	</table>

	<br />
	<%-- <div>
		<center>
			<c:if test="${pageNav.prevPage}">
				<a
					href="<c:url value='/action/showArticles?todo=articleList&page=${pageNav.startPage - 1}' />">prev</a>
			</c:if>
			<c:forEach var="page" begin="${pageNav.startPage}"
				end="${pageNav.endPage}">
				<a
					href="<c:url value='/action/showArticles?todo=articleList&page=${page}' />">[${page}]
				</a>
			</c:forEach>
			<c:if test="${pageNav.nextPage}">
				<a
					href="<c:url value='/action/showArticles?todo=articleList&page=${pageNav.endPage + 1}' />">next</a>
			</c:if>
		</center>
	</div> --%>
	<%@include file="always/bottom.jsp"%>
</body>
</html>