package com.AFK.travel56.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.AFK.travel56.service.ArticleService;

public class FrontCommand implements Command {
	
	public CommandResult execute(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult = new CommandResult(
				"/WEB-INF/view/front.jsp");
		HttpSession session = request.getSession(true);
		ArticleService articleService = new ArticleService();
		session.setAttribute("Articles", articleService
				.showAllArticleByContinent(request.getParameter("유럽")));

		return commandResult;
	}
}
