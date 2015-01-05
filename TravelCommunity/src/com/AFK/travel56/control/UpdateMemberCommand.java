package com.AFK.travel56.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.AFK.travel56.service.ArticleService;
import com.AFK.travel56.service.MemberService;

public class UpdateMemberCommand implements Command {

	public CommandResult execute(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult = new CommandResult(
				"/WEB-INF/view/updateMember.jsp");
		HttpSession session = request.getSession(true);
		MemberService memberService = new MemberService();
		session.setAttribute(
				"loginMember",
				memberService.loginMember(request.getParameter("id"),
						request.getParameter("pass")));

		return commandResult;
	}

}