package com.AFK.travel56.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.AFK.travel56.service.ArticleService;
import com.AFK.travel56.service.CommentService;

public class ReadArticleCommand implements Command {
	public CommandResult execute(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		
		CommandResult commandResult = new CommandResult(
				"/WEB-INF/view/readArticle.jsp");
		
		HttpSession session = request.getSession(true);
		
		ArticleService articleService = new ArticleService();
		CommentService commentService = new CommentService();
		
		session.setAttribute("Articles", articleService
				.selectShowArticle(Integer.parseInt(request.getParameter("idx"))));
		
//		session.setAttribute("Comment", commentService.
//				registerComment(commentContent, memberNumber, request.getParameter(arg0) , Integer.parseInt(request.getParameter("idx")));
		
		return commandResult;
	}
}