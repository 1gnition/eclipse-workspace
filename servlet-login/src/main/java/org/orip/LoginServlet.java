package org.orip;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		LoginService loginService = new LoginService();
		
		boolean valid = loginService.authenticate(username, password);
		
		if (valid) {
//			resp.sendRedirect("success.jsp");
//			HttpSession session = req.getSession();
//			session.setAttribute("username", username);
//			session.setAttribute("password", password);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("success.jsp");
			requestDispatcher.forward(req, resp);
			System.out.println("Success");
		} else {
//			resp.sendRedirect("login.jsp");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(req, resp);
			System.out.println("Failed");
		}
	}
	
}

