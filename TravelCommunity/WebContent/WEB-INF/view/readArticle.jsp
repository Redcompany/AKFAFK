<%@page import="com.AFK.travel56.dao.ArticleVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="true" import="java.util.*, com.AFK.travel56.dao.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">

<title>${showArticle.articleTitle}</title>
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
			<td>${showArticle.articleNumber}</td>
			<td>${showArticle.articleContinent}</td>
			<td>${showArticle.articleCountry}</td>
			<td>${showArticle.articleTitle}</td>
			<td>${showArticle.memberNickName}</td>
			<td>${showArticle.articleDate}</td>
			<td>${showArticle.articleRecommendCount}</td>
			<td>${showArticle.articleViewCount}</td>
		</tr>

		<tr align="center">
			<td colspan="8">${showArticle.articleContent}</td>
		</tr>
		
		<tr align="center">
			<td colspan="5"></td>
			<td colspan="3"><a class="skip" href="updateArticle">수정</a> <input
				type=button value="삭제"> <input type=button value="추천">
				<input type=button value="목록" OnClick="showArticles"></td>
		</tr>

		<tr>
			<td></td>
			
			<td colspan="6">
				<form name="commentAdd" action="<c:url value='/action/readArticle?idx=${showArticle.articleNumber}'/>"
					method="POST">
					<input type="hidden" name="todo" value="doRegisterComment">
					댓글입력 : <input type="text" name="inComment" size="60"
						placeholder="댓글을 입력해주세요"/>
					<input type="submit" value="달기">
				</form>
			</td>
			
			<td></td>
		</tr>

		<tr>
			<td></td>
			<td colspan="6">
				<table>
					<tr>
						<td><c:forEach var="viewComments" items="${showComments}">
								<c:choose>
									<c:when test="${viewComments==''}">
                           등록된 댓글이 없습니다. <%-- error --%>
									</c:when>
									<c:otherwise>
										<c:if test="${viewComments.getParentComment()==0}">
                              ${viewComments.memberNickName} : ${viewComments.commentContent} ( ${viewComments.commentdate }) <br />
										</c:if>
										<c:if test="${viewComments.getParentComment() > 0}">
                              ▶▶ ${viewComments.memberNickName} : ${viewComments.commentContent} ( ${viewComments.commentdate }) <br />
										</c:if>
									</c:otherwise>
								</c:choose>
							</c:forEach></td>
					</tr>
				</table>
			</td>
			<td></td>
			<td></td>
		</tr>
	</table>
</body>
</html>