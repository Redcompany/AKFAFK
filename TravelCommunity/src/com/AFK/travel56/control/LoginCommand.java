package com.AFK.travel56.control;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.AFK.travel56.service.MemberService;
//
//public class LoginCommand implements Command {
//
//	public CommandResult execute(HttpServletRequest request,
//			HttpServletResponse response)
//			throws javax.servlet.ServletException, java.io.IOException {
//		CommandResult commandResult = null;
//		HttpSession session = request.getSession(true);
//		MemberService memberService = new MemberService();
//		commandResult = new CommandResult("/WEB-INF/view/loginMember.jsp");
//
//		return commandResult;
//	}
//}

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.AFK.travel56.service.MemberService;
import com.AFK.travel56.dao.MemberDAO;
import com.AFK.travel56.dao.MemberVO;

public class LoginCommand implements Command {

	public CommandResult execute(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {

		CommandResult commandResult = null;
		HttpSession session = request.getSession();
		MemberService memberService = new MemberService();

		String memberID = request.getParameter("id");
		String memberPW = request.getParameter("password");

		MemberVO memberVO = memberService.loginCheck(memberID); 
		if (memberVO != null) {
			if (memberVO.getMemberPW().equals(memberPW)) {
				commandResult = new CommandResult(
						"/WEB-INF/view/loginsuccess.jsp");
				session.setAttribute("loginsession", memberVO);
			} else {
				request.setAttribute("loginfailuremessage",
						"password가 일치하지 않습니다.");
				commandResult = new CommandResult(
						"/WEB-INF/view/loginform.jsp");
			}
		} else {
			commandResult = new CommandResult(
					"/WEB-INF/view/loginform.jsp");
			request.setAttribute("loginfailuremessage", "ID를 확인해주세요.");
		}

		return commandResult;
	}
}
