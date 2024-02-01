package tech.codehunt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("login");
		session.removeAttribute("login");
		System.out.println("Log out : before " + new Login().activeSession());
		new Login().activeSession().remove(user);
		System.out.println("Log out : After " + new Login().activeSession());
		
		session.setAttribute("msg", "logout successfully..");
		response.sendRedirect("adminauth.jsp");
	}

}
