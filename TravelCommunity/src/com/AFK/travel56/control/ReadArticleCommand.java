package com.AFK.travel56.control;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import travel.MyFileRenamePolicy;

import com.AFK.travel56.dao.ArticleRecommandVO;
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
		if (request.getParameter("idx") != null) {
			session.setAttribute("Article", articleService
					.selectShowArticle(Integer.parseInt(request
							.getParameter("idx"))));
			return commandResult;
		} else {
			if (request.getParameter("todo").equals("글수정")) {

				ArticleVO findArticle = (ArticleVO) session
						.getAttribute("Article");
				findMember = (MemberVO) session.getAttribute("loginsession");
				session.setAttribute(
						"Article",
						articleService.updateArticle(
								findArticle.getArticleNumber(),
								request.getParameter("title"),
								request.getParameter("content"),
								findMember.getMemberNickName()));
				return commandResult;
			} else if (request.getParameter("todo").equals("추천")) {
				Date today = new Date();
				findMember = (MemberVO) session.getAttribute("loginsession");
				ArticleVO findArticle = (ArticleVO) session
						.getAttribute("Article");
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				if (findMember != null) {
					ArticleRecommandVO checkRecommand = articleService
							.checkRecommand(findArticle.getArticleNumber(),
									findMember.getMemberNickName());
					if (checkRecommand != null
							&& format.format(today).equals(
									format.format(checkRecommand
											.getRecommandDate()))) {
						System.out.println("이미 눌렀습니다.");

					} else {
						System.out.println("비교되는곳");
						request.setAttribute("recommand", articleService
								.doRecommandIncrement(
										findArticle.getArticleNumber(),
										findArticle.getArticleRecommendCount()));
						request.setAttribute("secceseRecommand", articleService
								.recommandAdd(findMember.getMemberNickName(),
										findArticle.getArticleNumber(),
										findMember.getMemberNumber()));
					}
				} else {
					System.out.println("로그인 해주세요");
				}

				return commandResult;
			}
		}

		return commandResult;
	}
}