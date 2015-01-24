<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="true" import="java.util.*, com.AFK.travel56.dao.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 수정 목록입니다.</title>
<style>
.mainBody {
	margin-top: 40px;
	margin-left: 100px;
	margin-right: 100px;
	border: 2px solid black;
}

.updateTable {
	
}

#updateText {
	position: relative;
	width: 1100px;
	height: 500px;
	margin-top: 20px;
	left: 40px;
	resize: none;
}

#updateTitleText {
	position: relative;
	margin-top: 20px;
	left: 40px;
	width: 1100px;
}
</style>
</head>
<body>
	<%@include file="always/top.jsp"%>
	<div class="mainBody">
		<form name="createArticleForm"
			action="<c:url value='/action/readArticle' />" method="POST">
			<table class="updateTable">
				<tr>
					<th><div>제목</div></th>
					<td ><input id="updateTitleText" name="title" type="text"
						value="${sessionScope.Article.articleTitle}" /></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea id="updateText" name="content">${sessionScope.Article.articleContent}</textarea></td>
				</tr>
			</table>
			<input type="submit" name="todo" value="글수정">
		</form>
	</div>
	<%@include file="always/bottom.jsp"%>
</body>
</html>