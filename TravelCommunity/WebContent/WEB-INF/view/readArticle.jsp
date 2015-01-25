<%@page import="com.AFK.travel56.service.FileService"%>
<%@page import="com.AFK.travel56.service.MemberService"%>
<%@page import="com.AFK.travel56.service.ArticleService"%>
<%@page import="com.AFK.travel56.dao.ArticleVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page session="true" import="java.util.*, com.AFK.travel56.dao.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<script>
	function clickMessage() {
		if (document.deleteArticleForm.todo.value == "삭제") {
			alert("글이 삭제되었습니다.")
			document.deleteArticleForm.submit();
		} else
			document.writeForm.submit();
	}
</script>
<title>${Article.articleTitle}</title>
<style>
.mainBody {
	margin-top: 40px;
	margin-left: 100px;
	margin-right: 100px;
}

#articleTable {
	width: 100%;
}

#content {
	width: 100%;
	height: auto;
	margin-top: 15px;
	margin-right: 60px;
	margin-bottom: 20px;
	border: 2px solid black;
}

#categoryName {
	position: relative;
	font-weight: bold;
	top: -20px;
	font-weight: bold;
}

.buttons {
	float: right;
	right: 70px;
}

.reply {
	margin-bottom: 20px;
}

form {
	display: inline;
}
</style>
</head>
<body>
	<%@include file="always/top.jsp"%>

	<div class="mainBody">
		<!-- table -->
		<h2 id="categoryName">${Article.articleContinent}</h2>
		<table class="table-default" id="articleTable">
			<tr>
				<th width="10%">번호</th>
				<th width="10%">나 라</th>
				<th width="30%">제 목</th>
				<th width="15%">아이디</th>
				<th width="15%">날 짜</th>
				<th width="15%">추천수</th>
				<th width="15%">조회수</th>
			</tr>
			<tr>
				<td>${Article.articleNumber}</td>
				<td>${Article.articleCountry}</td>
				<td>${Article.articleTitle}</td>
				<td>${Article.memberNickName}</td>
				<td>${Article.articleDate}</td>
				<td>${Article.articleRecommendCount}</td>
				<td>${Article.articleViewCount}</td>
			</tr>
		</table>
		<!-- table end -->

		<!-- content -->
		<div class="container-fluid" id="content">
			<%
				ArticleVO readArticle = (ArticleVO) session.getAttribute("Article");
				if (readArticle != null) {
					FileService fileService = new FileService();
					List<FileVO> theFiles = fileService
							.showFilesByArticle(readArticle.getArticleNumber());
					if (theFiles != null && theFiles.size() > 0) {

						for (int i = 0; i < theFiles.size(); ++i) {
							FileVO findFile = theFiles.get(i);
							String filename = request.getContextPath() + "/images/"
									+ findFile.getFileName();
			%>
			<img src=<%=filename%> style="width: 510px; height: 270px"> <br>
			<%
				}
					}
				}
			%>
			${sessionScope.Article.articleContent}
		</div>
		<!-- content end -->

		<!-- buttons -->
		<div class="buttons">
			<form >
				<a href="showArticles?todo=doing&country=${Article.articleCountry}"><input type=button value="목록"></a>
				<a href="updateArticle"><input type="button" value="수정"></a>
			</form>
			<form name="deleteArticleForm" action="<c:url value='/action/home'/>"
				method="POST">
				<input type="hidden" name="todo" value="삭제"> <input
					type=submit onclick="javascript:clickMessage()" value="삭제">
			</form>
			<form name="articleRcommandForm"
				action="<c:url value='/action/readArticle?idx=${Article.articleNumber}'/>"
				method="POST">
				<input type="submit" name="todo" value="추천">
			</form>
		</div>
		<!-- buttons end -->

		<!-- reply -->
		<div class="reply">
			<form name="commentAdd"
				action="<c:url value='/action/readArticle?idx=${Article.articleNumber}'/>"
				method="POST">
				<input type="hidden" name="todo" value="doRegisterComment">
				댓글입력 : <input type="text" name="inComment" size="60"
					placeholder="댓글을 입력해주세요" /> <input type="submit" value="댓글달기">
			</form>
		</div>
		<!-- reply end -->

		<!-- reply list -->
		<div class="replyList">
			<c:forEach var="viewComments" items="${showComments}">
				<c:choose>
					<c:when test="${viewComments==''}">
                           등록된 댓글이 없습니다. error
									</c:when>
					<c:otherwise>
						<c:if test="${viewComments.getParentComment()==0}">
                              ${viewComments.memberNickName} : ${viewComments.commentContent} ( ${viewComments.commentdate }) <br>
							<c:if
								test="${deleteComment.memberNickName eq viewComments.memberNickName }">
								<a href="/action/readArticle?idx=${Article.articleNumber}">삭제</a>
							</c:if>
						</c:if>
						<c:if test="${viewComments.getParentComment() > 0}">
                              ▶▶ ${viewComments.memberNickName} : ${viewComments.commentContent} ( ${viewComments.commentdate }) <br />
						</c:if>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
		<!-- reply list end -->
	</div>
	<%@include file="always/bottom.jsp"%>
</body>
</html>