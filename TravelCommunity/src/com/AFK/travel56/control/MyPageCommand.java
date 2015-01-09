package com.AFK.travel56.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.AFK.travel56.dao.MemberVO;
import com.AFK.travel56.service.MemberService;

public class MyPageCommand implements Command {

	public CommandResult execute(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {

		CommandResult commandResult = null;
		HttpSession session = request.getSession(true);
		MemberService memberService = new MemberService();

		MemberVO memberVO = (MemberVO) session.getAttribute("loginsession");
		if (request.getParameter("rePass") != null) {
			if (request.getParameter("rePass").equals(
					request.getParameter("reconPass"))) {
				session.setAttribute("loginsession", memberService
						.updateMember((memberVO.getMemberNickName()),
								(memberVO.getMemberPW()),
								request.getParameter("rePass"),
								request.getParameter("rename"),
								request.getParameter("changePhonenumber"),
								request.getParameter("changeMail")));
				commandResult = new CommandResult("/WEB-INF/view/mypage.jsp");
			}
		} else {

			commandResult = new CommandResult("/WEB-INF/view/mypage.jsp");
		}
		return commandResult;
	}
}
