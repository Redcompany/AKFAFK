package com.AFK.travel56.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.AFK.travel56.service.MemberService;

public class HomeCommand implements Command {
	public CommandResult execute(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult = null;
		String todoCheck = request.getParameter("todo");
		if (todoCheck != null) {
			MemberService memberService = new MemberService();
			switch (todoCheck) {

			case "회원가입":
				request.setAttribute("addMember", memberService.registerMember(
						request.getParameter("id"),
						request.getParameter("pass"),
						request.getParameter("gender"),
						request.getParameter("email"),
						request.getParameter("address"),
						request.getParameter("name"),
						request.getParameter("birth"),
						request.getParameter("nickname")));
				break;
			case "ID찾기":
				request.setAttribute("findID", memberService.findMemberID(
						request.getParameter("name"),
						request.getParameter("birth"),
						request.getParameter("nickname")));
				System.out.println(memberService.findMemberID(
						request.getParameter("name"),
						request.getParameter("birth"),
						request.getParameter("nickname")));
				break;
			case "Password찿기":
				request.setAttribute(
						"findPassword",
						memberService.findMemberPassword(
								request.getParameter("id"),
								request.getParameter("name"),
								request.getParameter("birth")));
				System.out.println(memberService.findMemberPassword(
						request.getParameter("id"),
						request.getParameter("name"),
						request.getParameter("birth")));
				System.out.println(request.getParameter("name"));

				break;

			case "로그인":
				request.setAttribute("memberLogin", memberService.loginMember(
						request.getParameter("id"),
						request.getParameter("pass")));
				break;
				// case "회워정보변경":
				// request.setAttribute("updateMember", memberService
				// .updateMember(request.getParameter("id"),
				// request.getParameter("pass"),
				// request.getParameter("email"),
				// request.getParameter("name"),
				// request.getParameter("phone")));
				// break;
			case "탈퇴":
				request.setAttribute("deleteMember", memberService
						.deleteMember(request.getParameter("id"),
								request.getParameter("pass")));
				break;
			}

		}
		commandResult = new CommandResult("/WEB-INF/view/home.jsp");
		return commandResult;
	}
}
