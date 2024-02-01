package tech.codehunt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tech.codehunt.dao.MessageDaoImpl;
import tech.codehunt.validation.Validation;

@WebServlet("/Message")
public class Message extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String result;
	  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String check = request.getParameter("check");
		
		if(check==null) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String message = request.getParameter("message");
			
			result = new Validation().validateMessage(name, email, message);
			if(result.equals("valid")) {
				result = new MessageDaoImpl().insert(name, email, message);
				if(result.equals("saved")) {
					session.setAttribute("msg", "message sent successfully..");
					response.sendRedirect("index.jsp");
				}
				else {
					session.setAttribute("msg", "something went wrong..");
					response.sendRedirect("index.jsp");
				}
			}
			else {
				System.out.println(result);
				session.setAttribute("msg", result);
				response.sendRedirect("index.jsp");
			}
		}
		else if(check.equals("deletemessage")){
			String sn = request.getParameter("sn");
			result = new MessageDaoImpl().delete(sn);
			if(result.equals("deleted")) {
				session.setAttribute("msg", "message deleted successfully..");
				response.sendRedirect("read-message.jsp");
			}
			else {
				session.setAttribute("msg", "something went wrong..");
				response.sendRedirect("read-message.jsp");
			}
		}
		
	}

}
