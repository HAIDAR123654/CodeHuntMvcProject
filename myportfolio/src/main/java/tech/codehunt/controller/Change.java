package tech.codehunt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tech.codehunt.dao.LoginDaoImpl;

@WebServlet("/Change")
public class Change extends HttpServlet {
	
	private String result;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		result = new LoginDaoImpl().updateLoginInfo(username, password);
		
		if(result.equals("updated")) {
			session.removeAttribute("login");
			session.setAttribute("msg", "credentials updated successfully..");
			response.sendRedirect("adminauth.jsp");
		}  
		else {
			session.setAttribute("msg", "something went wrong..");
			response.sendRedirect("admin.jsp");
		}
		
	}

}
