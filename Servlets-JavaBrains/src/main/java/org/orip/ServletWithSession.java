package org.orip;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletWithSession extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String name = req.getParameter("name");
		HttpSession session = req.getSession();
		
		if (name != null) {
			session.setAttribute("name", name);
		}
		
		String savedName = (String) session.getAttribute("name");
		
		resp.getWriter().print("Your name is " + savedName);
		
		
	}
	
	

}
