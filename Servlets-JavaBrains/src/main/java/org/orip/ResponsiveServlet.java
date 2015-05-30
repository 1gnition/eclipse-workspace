package org.orip;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponsiveServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String name = req.getParameter("name");
		resp.getWriter().print("Hello " + name + "!");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		String prof = req.getParameter("prof");
		String[] locations = req.getParameterValues("location");
		resp.getWriter().print(
				"<h3>Your name is " + name +
				", your profession is " + prof +
				" and you are in " + Arrays.toString(locations) + "</h3>");
	}
	
	
	

}
