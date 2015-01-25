<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="true" import="java.util.*, travel.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="styles.css">
<title>행복했던 여행을 추억하세요</title>
</head>
<body>
	<%@include file="always/top.jsp"%>
	<div class="createArticle">
		<form name="createArticleForm" enctype="multipart/form-data"
			action="<c:url value='/action/showArticles' />" method="POST">

			<select name="continent" >
				<option value="유럽">유럽</option>
				<option value="아시아">아시아</option>
				<option value="오세아니아">오세아니아</option>
				<option value="아프리카">아프리카</option>
				<option value="북아메리카">북아메리카</option>
				<option value="남아메리카">남아메리카</option>
			</select><div class="form-group">

            <div class="col-lg-2" id="countryDIV">
                <input type="text" class="form-control" id="country" name="country" placeholder="나라를 입력해주세요">
            </div>
        </div><br>
			<table align="center">
				<th><input name="title" type="text" class="form-control"
					style="width: 500px; height: 30px;" placeholder="제목을 입력해주세요" /></th>
				</tr>

				<tr>
					<td colspan="3" align="center"><p>내용</p></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><textarea id="content" name="content"
							class="form-control" rows="30" cols="80" placeholder="내용을 입력해주세요"></textarea><br></td>
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
					<td align="right"><input type="submit" value="글등록"></td>
				</tr>
			</table>
		</form>

	</div>
	<%@include file="always/bottom.jsp"%>
</body>
</html>