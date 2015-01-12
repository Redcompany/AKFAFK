package com.AFK.travel56.control;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import travel.MyFileRenamePolicy;

import com.AFK.travel56.dao.ArticleVO;
import com.AFK.travel56.dao.MemberVO;
import com.AFK.travel56.service.ArticleService;
import com.AFK.travel56.service.CommentService;
import com.AFK.travel56.service.FileService;
import com.oreilly.servlet.MultipartRequest;

public class ReadArticleCommand implements Command {
	public CommandResult execute(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {

		CommandResult commandResult = new CommandResult(
				"/WEB-INF/view/readArticle.jsp");
		ArticleService articleService = new ArticleService();
		FileService fileService = new FileService();
		HttpSession session = request.getSession(true);
		MemberVO findMember = null;
		// request.setAttribute("showComments", commentService
		// .showAllCommentByArticle(Integer.parseInt(request
		// .getParameter("idx"))));
		// System.out.println(request.getParameter("todo"));

		if (request.getParameter("idx") != null) {
			session.setAttribute("Article", articleService
					.selectShowArticle(Integer.parseInt(request
							.getParameter("idx"))));
			return commandResult;
		} else if (request.getParameter("todo").equals("글수정")) {
			ArticleVO findArticle = (ArticleVO) session.getAttribute("Article");
			findMember = (MemberVO) session.getAttribute("loginsession");
			session.setAttribute("Article", articleService.updateArticle(
					findArticle.getArticleNumber(),
					request.getParameter("title"),
					request.getParameter("content"),
					findMember.getMemberNickName()));
			return commandResult;
		}

		return commandResult;
	}
}