package com.AFK.travel56.control;

import javax.servlet.http.*;

public interface Command {
	public CommandResult execute(HttpServletRequest request,
			HttpServletResponse response)
			throws javax.servlet.ServletException, java.io.IOException;
}
