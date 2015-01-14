package com.AFK.travel56.control;

import java.util.Enumeration;
import java.util.List;

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


		CommandResult commandResult = null;

		HttpSession session = request.getSession(true);
		
		String todo = request.getParameter("todo");
		System.out.println(todo);
		
		try {
			switch (todo) {
			case "read":
				doRead(request, response);
				commandResult = new CommandResult("/WEB-INF/view/readArticle.jsp");
				break;
			case "doRegisterComment":
				doRegisterComment(request, response);
				commandResult = new CommandResult("/WEB-INF/view/readArticle.jsp");
				break;
			case "수정":
				doUpdateArticle(request, response);
				commandResult = new CommandResult("/WEB-INF/view/readArticle.jsp");
				break;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
		}
		return commandResult;

	}
	
	private void doRead(HttpServletRequest request, HttpServletResponse response) {
		ArticleService articleService = new ArticleService();
		CommentService commentService = new CommentService();
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		System.out.println(idx);
		request.setAttribute("showArticle", articleService.selectShowArticle(idx));
		request.setAttribute("showComments", commentService.showAllCommentByArticle(idx));
	}
	
	public void doRegisterComment(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		ArticleService articleService = new ArticleService();
		CommentService commentService = new CommentService();
		MemberVO commentMember = (MemberVO) session
				.getAttribute("loginsession");
		int idx = Integer.parseInt(request.getParameter("idx"));
		System.out.println(idx);
	
		session.setAttribute("registerComment", commentService
				.registerComment(request.getParameter("inComment"),
						commentMember.getMemberNumber(),
						commentMember.getMemberNickName(),
						idx));
		request.setAttribute("showArticle", articleService.selectShowArticle(idx));
		request.setAttribute("showComments", commentService.showAllCommentByArticle(idx));
	}
	
	private void doUpdateArticle(HttpServletRequest request, HttpServletResponse response) {
		ArticleService articleService = new ArticleService();
		HttpSession session = request.getSession(true);
		MemberVO findMember = null;
		ArticleVO findArticle = (ArticleVO) session.getAttribute("Article");
		findMember = (MemberVO) session.getAttribute("loginsession");
		session.setAttribute("Article", articleService.updateArticle(
				findArticle.getArticleNumber(),
				request.getParameter("title"),
				request.getParameter("content"),
				findMember.getMemberNickName()));
	}
}