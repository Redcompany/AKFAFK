package com.AFK.travel56.control;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import travel.MyFileRenamePolicy;

import com.AFK.travel56.dao.ArticleVO;
import com.AFK.travel56.service.ArticleService;
import com.AFK.travel56.service.FileService;
import com.AFK.travel56.service.MemberService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class HomeCommand implements Command {
	public CommandResult execute(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult = null;
		MemberService memberService = new MemberService();
		
		String todoCheck = request.getParameter("todo");
		HttpSession session=request.getSession(true);
		if (todoCheck != null) {

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
			case "로그아웃":
				session.removeAttribute("loginsession");
				break;
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
