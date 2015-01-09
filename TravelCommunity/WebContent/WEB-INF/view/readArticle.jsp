<%@page import="com.AFK.travel56.dao.ArticleVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="true" import="java.util.*, com.AFK.travel56.dao.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<%
	ArticleVO readArticle = (ArticleVO) session
			.getAttribute("Article");
	if (readArticle != null) {
%>
<title>글보기 | <%=readArticle.getArticleTitle()%></title>
</head>
<body>

	<table id="Articleboard" width="75%" height="65" align="center"
		border="0">

		<tr class="bestbackground">
			<th width="50">Number</th>
			<th width="150">대 륙</th>
			<th width="150">나 라</th>
			<th width="370">제 목</th>
			<th width="200">I D</th>
			<th width="100">날 짜</th>
			<th width="80">추천수</th>
			<th width="80">조회수</th>
		</tr>

		<tr align="center">
			<input type="hidden" name="cartIndex" value="listValue">
			<td><%=readArticle.getArticleNumber()%></td>
			<td><%=readArticle.getArticleContinent()%></td>
			<td><%=readArticle.getArticleCountry()%></td>
			<td><%=readArticle.getArticleTitle()%></td>
			<td><%=readArticle.getMemberNickName()%>
			<td><%=readArticle.getArticleDate()%></td>
			<td><%=readArticle.getArticleRecommendCount()%></td>
			<td><%=readArticle.getArticleViewCount()%></td>
		</tr>

		<tr align="center">
			<td colspan="8"><%=readArticle.getArticleContent()%></td>
		</tr>

		<tr align="center">
			<td colspan="5"></td>
			<td colspan="3"><a class="skip" href="updateArticle">수정</a> <input
				type=button value="삭제"> <input type=button value="추천">
				<input type=button value="목록" OnClick="showArticles.jsp"></td>
		</tr>

		<tr>
			<td></td>
			<td colspan="6">
				<form>
					댓글입력 : <input type="text" size="75" name="comment"> <input
						type="button" value="달기">
				</form>
			</td>
			<td></td>
		</tr>
		<%-- <%
		CommentVO commentVO = (CommentVO) session
				.getAttribute("Articles");
		if (commentVO != null) {
		%> --%>

		<tr>
			<td></td>
			<td colspan="6"></td>
			<td></td>
		</tr>


	</table>
	<br /> <
	<%
		/* } */
		}
	%>
</body>
</html>