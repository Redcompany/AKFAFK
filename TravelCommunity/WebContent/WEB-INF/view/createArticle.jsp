<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="true" import="java.util.*, travel.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>행복했던 여행을 추억하세요</title>
</head>
<body>
	<%@include file="always/top.jsp"%>

	<form name="createArticleForm" enctype="multipart/form-data"
		action="<c:url value='/action/showArticles' />" method="POST">
		<table  align="center">
			<tr>
				<th><input type="checkbox" name="continent" value="유럽">유럽
				</th>
				<th><input type="checkbox" name="country" value="영국">영국
				</th>
				<th><input name="title" type="text"
					style="width: 500px; height: 30px;" placeholder="제목을 입력해주세요" /></th>
			</tr>

			<tr>
				<td colspan="3"  align="center"><p>내용</p></td>
			</tr>
			<tr>
				<td colspan="3"  align="center"><textarea name="content" rows="30" cols="80"
						placeholder="내용을 입력해주세요"></textarea><br></td>
			</tr>
			<tr>
				<td>파일명1 :</td>
				<td colspan="2"><input id="files-upload1" type="file"
					name="filename"></td>
			</tr>
			<tr>
				<td>파일명2 :</td>
				<td colspan="2"><input id="files-upload2" type="file"
					name="filename1"></td>
			</tr>
			<tr>
				<td colspan="2"></td>
				<td  align="right"><input type="submit" value="글등록"></td>
			</tr>
		</table>
	</form>


	<%@include file="always/bottom.jsp"%>
</body>
</html>