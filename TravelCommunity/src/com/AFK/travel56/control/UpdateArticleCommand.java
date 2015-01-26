package com.AFK.travel56.control;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.AFK.travel56.dao.ArticleVO;
import com.AFK.travel56.dao.MemberVO;


public class UpdateArticleCommand implements Command{
	public CommandResult execute(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {
		CommandResult commandResult = new CommandResult(
				"/WEB-INF/view/updateArticle.jsp");
		HttpSession session = request.getSession(true);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(session.getAttribute("loginsession")!=null){
		ArticleVO findArticle=(ArticleVO)session.getAttribute("Article");
		MemberVO findMember=(MemberVO)session.getAttribute("loginsession");
		if(findArticle.getMemberNickName().equals(findMember.getMemberNickName())){
		}else{
			out.println("<script>alert('수정하실수 없습니다.'); history.go(-1);</script>");
			out.flush();
		}
		
		}else{
			out.println("<script>alert('수정하실수 없습니다.'); history.go(-1);</script>");
			out.flush();
		}
		return commandResult;
	}
}
