package com.AFK.travel56.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.AFK.travel56.dao.MemberVO;
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

		request.setAttribute("readArticle",
				articleService.selectShowArticle(Integer.parseInt(request
						.getParameter("idx"))));
		
		request.setAttribute("showComments", 
				commentService.showAllCommentByArticle(Integer.parseInt(request
						.getParameter("idx"))));

//		MemberVO findMember = (MemberVO) request.getAttribute("loginsession");

		request.setAttribute("inComment", commentService.registerComment(
				request.getParameter("inComment"), 
				1,
//				findMember.getMemberNumber(),
				"우리조화이팅",
//				findMember.getMemberNickName(),
				Integer.parseInt(request.getParameter("idx"))));

		return commandResult;
	}
}