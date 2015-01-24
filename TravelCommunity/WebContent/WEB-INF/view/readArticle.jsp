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

</head>


<body>
	<%@include file="always/top.jsp"%>
	<table id="Articleboard" height="200" align="center" border="0" class="articlesTable">
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
			<td>${Article.articleNumber}</td>
			<td>${Article.articleContinent}</td>
			<td>${Article.articleCountry}</td>
			<td>${Article.articleTitle}</td>
			<td>${Article.memberNickName}</td>
			<td>${Article.articleDate}</td>
			<td>${Article.articleRecommendCount}</td>
			<td>${Article.articleViewCount}</td>

		</tr>

		<tr align="center">
			<td colspan="8" height="auto" style="word-break: break-all;">
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
				%> <img src=<%=filename%> style="width: 304px; height: 228px">
				<br> <%
 	}
 		}
 	}
 %> ${Article.articleContent}
			</td>
		</tr>


		<tr align="center">
			<td colspan="5"></td>
			<form>
				<td colspan="3"><input type=button value="목록"
					OnClick="showArticles.jsp"><a href="updateArticle"><input
						type=button value="수정"></a>
					<form name="deleteArticleForm"
						action="<c:url value='/action/home'/>" method="POST">
						<input type="hidden" name="todo" value="삭제"> <input
							type=submit onclick="javascript:clickMessage()" value="삭제">
						<form name="articleRcommandForm"
							action="<c:url value='/action/readArticle?idx=${Article.articleNumber}'/>"
							method="POST">
							<input type="submit" name="todo" value="추천">
						</form>
					</form></td>
			</form>
		</tr>

		<tr>
			<td></td>
			<td colspan="6">
				<form name="commentAdd"
					action="<c:url value='/action/readArticle?idx=${Article.articleNumber}'/>"
					method="POST">
					<input type="hidden" name="todo" value="doRegisterComment">
					댓글입력 : <input type="text" name="inComment" size="60"
						placeholder="댓글을 입력해주세요" /> <input type="submit" value="달기">
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
                           등록된 댓글이 없습니다. error
									</c:when>
									<c:otherwise>
										<c:if test="${viewComments.getParentComment()==0}">
                              ${viewComments.memberNickName} : ${viewComments.commentContent} ( ${viewComments.commentdate })
                          <c:if
												test="${deleteComment.memberNickName eq viewComments.memberNickName }">
												<a href="/action/readArticle?idx=${Article.articleNumber}">삭제</a>
											</c:if>
											<br />
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

	<%@include file="always/bottom.jsp"%>
</body>
</html>