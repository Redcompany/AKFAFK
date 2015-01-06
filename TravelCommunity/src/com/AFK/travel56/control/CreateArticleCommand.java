package com.AFK.travel56.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateArticleCommand implements Command{

	public CommandResult execute(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult = new CommandResult(
				"/WEB-INF/view/createArticle.jsp");
		return commandResult;
	}

}
