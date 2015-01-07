package com.AFK.travel56.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command{
	
	public CommandResult execute(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException {

		CommandResult commandResult = null;
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginsession") != null){
			session.invalidate();
		    request.setAttribute("loginfailuremessage", "로그아웃 되었습니다.");
		    commandResult=new CommandResult("/WEB-INF/view/loginform.jsp");
		    
		}
		return commandResult;
	}
}