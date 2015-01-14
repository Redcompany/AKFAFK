package com.AFK.travel56.control;

import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import travel.MyFileRenamePolicy;

import com.AFK.travel56.dao.ArticleVO;
import com.AFK.travel56.dao.MemberVO;
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
		ArticleService articleService = new ArticleService();
		request.setAttribute("showBestArticle",
				articleService.showAllBestArticle());
		request.setAttribute("findBestArticleByEurope",
				articleService.showBestArticleByContinent("유럽"));
		request.setAttribute("findBestArticleByNotice",
				articleService.showBestArticleByContinent("공지"));
		request.setAttribute("findBestArticleByAsia",
				articleService.showBestArticleByContinent("아시아"));
		request.setAttribute("findBestArticleByAfrica",
				articleService.showBestArticleByContinent("아프리카"));
		request.setAttribute("findBestArticleByNorthAmerican",
				articleService.showBestArticleByContinent("북아메리카"));
		request.setAttribute("findBestArticleBySouthAmerican",
				articleService.showBestArticleByContinent("남아메리카"));
		request.setAttribute("findBestArticleByOceania",
				articleService.showBestArticleByContinent("오세아니아"));

		String todoCheck = request.getParameter("todo");
		HttpSession session = request.getSession(true);
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
				PrintWriter outid = response.getWriter();
				String p = memberService.findMemberID(
						request.getParameter("name"),
						request.getParameter("birth"),
						request.getParameter("nickname"));
				response.setContentType("text/html; charset=UTF-8");
				outid.println("<script>alert('" + p
						+ "'); history.go(-1);</script>");
				outid.flush();
				break;
			case "Password찾기":
				request.setAttribute(
						"findPassword",
						memberService.findMemberPassword(
								request.getParameter("id"),
								request.getParameter("name"),
								request.getParameter("birth")));
				PrintWriter outpw = response.getWriter();
				String i = memberService.findMemberPassword(
						request.getParameter("id"),
						request.getParameter("name"),
						request.getParameter("birth"));
				response.setContentType("text/html; charset=UTF-8");
				outpw.println("<script>alert('" + i
						+ "'); history.go(-1);</script>");
				outpw.flush();
				break;
			case "로그인":
				request.setAttribute("memberLogin", memberService.loginMember(
						request.getParameter("id"),
						request.getParameter("pass")));
				break;
			case "로그아웃":
				session.removeAttribute("loginsession");
				break;
			case "탈퇴":
				MemberVO memberVO = (MemberVO) session
						.getAttribute("loginsession");
				request.setAttribute("deleteMember", memberService
						.deleteMember(memberVO.getMemberID(),
								memberVO.getMemberPW()));
				session.removeAttribute("loginsession");
				break;
			}
		}

		commandResult = new CommandResult("/WEB-INF/view/home.jsp");
		return commandResult;
	}
}
