package com.AFK.travel56.control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateArticleCommand implements Command{

	public CommandResult execute(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		HttpSession session = request.getSession(true);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		CommandResult commandResult = new CommandResult(
				"/WEB-INF/view/createArticle.jsp");
		if(session.getAttribute("loginsession")!=null){
		}else{
			out.println("<script>alert('로그인을 해주세요'); history.go(-1);</script>");
			out.flush();
		}
	
		return commandResult;
	}

}
