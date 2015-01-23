<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="true" import="java.util.*, com.AFK.travel56.dao.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 수정 목록입니다.</title>
</head>
<body>
	<%@include file="always/top.jsp"%>
	<form name="createArticleForm" align="center"
		action="<c:url value='/action/readArticle' />" method="POST">
		<p>제목</p>
		<input name="title" type="text" style="width: 500px; height: 30px;"
			value="${sessionScope.Article.articleTitle}" /><br>
		<p>내용</p>
		<textarea name="content" rows="10" cols="30">${sessionScope.Article.articleContent}</textarea>
		<br> <input type="submit" name="todo" value="글수정">
	</form>
	<%@include file="always/bottom.jsp"%>
</body>
</html>