package com.AFK.travel56.control;

import javax.servlet.http.HttpServletRequest;

public class RequestHelper {
	HttpServletRequest request;
	CommandFactory commandFactory;
	
	public RequestHelper(HttpServletRequest request) {
		this.request = request;		
		commandFactory = new CommandFactory();
	}
	
	public Command getCommand() {
		Command target = null;
		
		/*
		 * URL Mapping
		 * 1. /order : 주문 페이지 보기 
		 * 2. /cart : cart관련 요청 (todo=remove, add 등) 
		 * 3. /checkout : 결제  
		 */
		System.out.println("Servlet Path : " + request.getServletPath());
		System.out.println("Path Info : " + request.getPathInfo());
		System.out.println("Request URI : " + request.getRequestURI());
		
		target = CommandFactory.createCommand(request.getPathInfo());
		return target;		
	}

}

