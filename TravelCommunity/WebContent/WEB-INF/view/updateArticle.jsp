<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 수정 목록입니다.</title>
</head>
<body>
	<form name="createArticleForm" enctype="multipart/form-data"
		action="<c:url value='/action/readArticle' />" method="POST">


		<p>제목</p>
		<input name="title" type="text" style="width: 500px; height: 30px;" />${sessionScope.Articles.articleTitle}<br>
		<p>내용</p>
		<textarea name="content" rows="10" cols="30"
			value=${sessionScope.Articles.articleContent}></textarea>
		<br> 파일명 : <input id="files-upload1" type="file" name="filename"><br>
		<br> 파일명1 : <input id="files-upload2" type="file"
			name="filename1"><br> <input type="submit" name="todo"
			value="글등록">
	</form>
</body>
</html>