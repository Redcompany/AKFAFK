package com.AFK.travel56.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.AFK.travel56.dao.ArticleRecommandVO;
import com.AFK.travel56.dao.ArticleVO;
import com.AFK.travel56.dao.MemberVO;
import com.AFK.travel56.service.ArticleService;
import com.AFK.travel56.service.CommentService;

public class ReadArticleCommand implements Command {
	public CommandResult execute(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {

		CommandResult commandResult = null;
		String todo = request.getParameter("todo");

		try {
			switch (todo) {
			case "read":
				doRead(request, response);
				commandResult = new CommandResult(
						"/WEB-INF/view/readArticle.jsp");
				break;
			case "doRegisterComment":
				doRegisterComment(request, response);
				commandResult = new CommandResult(
						"/WEB-INF/view/readArticle.jsp");
				break;
			case "글수정":
				doUpdateArticle(request, response);
				commandResult = new CommandResult(
						"/WEB-INF/view/readArticle.jsp");
				break;
			case "추천":
				doBestArticle(request, response);
				commandResult = new CommandResult(
						"/WEB-INF/view/readArticle.jsp");
				break;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
		}
		return commandResult;
	}

	private void doRead(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(true);
		ArticleService articleService = new ArticleService();
		CommentService commentService = new CommentService();

		int idx = Integer.parseInt(request.getParameter("idx"));
		System.out.println(idx);

		session.setAttribute("Article", articleService.selectShowArticle(idx));
		request.setAttribute("showComments",
				commentService.showAllCommentByArticle(idx));
	}

	public void doRegisterComment(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession(true);
		ArticleService articleService = new ArticleService();
		CommentService commentService = new CommentService();
		MemberVO commentMember = (MemberVO) session
				.getAttribute("loginsession");

		int idx = Integer.parseInt(request.getParameter("idx"));
		System.out.println(idx);

		session.setAttribute(
				"registerComment",
				commentService.registerComment(
						request.getParameter("inComment"),
						commentMember.getMemberNumber(),
						commentMember.getMemberNickName(), idx));
		session.setAttribute("Article", articleService.selectShowArticle(idx));
		request.setAttribute("showComments",
				commentService.showAllCommentByArticle(idx));
	}

	public void doDeleteComment(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession(true);
		ArticleService articleService = new ArticleService();
		CommentService commentService = new CommentService();
		MemberVO commentMember = (MemberVO) session
				.getAttribute("loginsession");

		int idx = Integer.parseInt(request.getParameter("idx"));
		System.out.println(idx);

		session.setAttribute("deleteComment", commentService.deleteComment(
				Integer.parseInt(request.getParameter("commentNumber")),
				commentMember.getMemberNumber(),
				commentMember.getMemberNickName()));
		session.setAttribute("Article", articleService.selectShowArticle(idx));
		request.setAttribute("showComments",
				commentService.showAllCommentByArticle(idx));
	}

	private void doUpdateArticle(HttpServletRequest request,
			HttpServletResponse response) {

		ArticleService articleService = new ArticleService();
		HttpSession session = request.getSession(true);
		MemberVO findMember = null;
		ArticleVO findArticle = (ArticleVO) session.getAttribute("Article");
		findMember = (MemberVO) session.getAttribute("loginsession");

		session.setAttribute("Article",
				articleService.updateArticle(findArticle.getArticleNumber(),
						request.getParameter("title"),
						request.getParameter("content"),
						findMember.getMemberNickName()));
	}

	private void doBestArticle(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		Date today = new Date();
		ArticleService articleService = new ArticleService();
		HttpSession session = request.getSession(true);
		MemberVO findMember = null;

		findMember = (MemberVO) session.getAttribute("loginsession");
		ArticleVO findArticle = (ArticleVO) session.getAttribute("Article");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if (findMember != null) {
			ArticleRecommandVO checkRecommand = articleService.checkRecommand(
					findArticle.getArticleNumber(),
					findMember.getMemberNickName());
			if (checkRecommand != null
					&& format.format(today).equals(
							format.format(checkRecommand.getRecommandDate()))) {

				out.println("<script>alert('이미 추천이 되었습니다.'); history.go(-1);</script>");
				out.flush();
			} else {
				request.setAttribute(
						"recommand",
						articleService.doRecommandIncrement(
								findArticle.getArticleNumber(),
								findArticle.getArticleRecommendCount()));
				request.setAttribute(
						"secceseRecommand",
						articleService.recommandAdd(
								findMember.getMemberNickName(),
								findArticle.getArticleNumber(),
								findMember.getMemberNumber()));
				System.out.println("2");
				out.println("<script>alert('추천되었습니다.');</script>");
				out.flush();
			}
		} else {

			System.out.println(response.getContentType());
			response.getContentType();
			out.println("<script>alert('로그인을 해주세요'); history.go(-1);</script>");
			out.flush();
		}
	}

}