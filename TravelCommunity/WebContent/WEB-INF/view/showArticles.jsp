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
	href="http://localhost:9999/TravelCommunity/css/material.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet">
<link href="css/ripples.min.css" rel="stylesheet">
<link href="css/material-wfont.min.css" rel="stylesheet">
</head>
<body>
	<%@include file="always/top.jsp"%>
	<p>
		<%
			if (request.getParameter("country") == null) {
		%>
		<strong><%=request.getParameter("continent")%> 게시판</strong>
		<%
			} else {
		%>
		<strong><%=request.getParameter("country")%> 게시판</strong>
		<%
			}
		%>
	</p>
<%-- 	<%
	//페이징을 위한 변수 선언
	int totalRecord = 0; // 전체 글의 갯수
	int numPerPage = 5; // 한 페이지당 보여질 글의 갯수
	int pagePerBlock = 3; // 한 블럭(1~3페이지)당 수
	int totalPage = 0; // 전체 페이지 수 
	int totalBlock = 0; // 전체 블럭 수
	int nowPage = 0; // 현재 보여질 페이지
	int nowBlock = 0; // 현재 보여질 블럭
	int beginPerPage = 0; // 각 페이지의 시작 글 번호
	%> --%>
	<table class="table table-striped table-hover ">
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
	<%@include file="always/bottom.jsp"%>
</body>
</html>