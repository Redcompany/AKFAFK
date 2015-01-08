package com.AFK.travel56.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.AFK.travel56.control.CommandResult;
import com.AFK.travel56.dao.MemberVO;
import com.AFK.travel56.service.MemberService;

public class LoginFormCommand implements Command {

	public CommandResult execute(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {

		CommandResult commandResult = null;
		HttpSession session = request.getSession(true);
		MemberService memberService = new MemberService();

		String memberID = request.getParameter("id");
		String memberPW = request.getParameter("password");

		MemberVO memberVO = memberService.loginMember(memberID, memberPW);
		session.setAttribute("loginsession", memberVO);
		commandResult = new CommandResult("/WEB-INF/view/loginsuccess.jsp");
		return commandResult;
	}
}
