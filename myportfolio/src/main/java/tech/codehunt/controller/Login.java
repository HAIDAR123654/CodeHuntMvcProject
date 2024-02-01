package tech.codehunt.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tech.codehunt.dao.LoginDaoImpl;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final Set<String> activesessions = new HashSet<>();

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String passowrd = request.getParameter("password");

		HttpSession session = request.getSession();

		String result = new LoginDaoImpl().checkCredentials(username, passowrd);

		if (result.equals("exist")) {
			if (!alreadyLogin(username)) {
				System.out.println(username + " is already logined");
				session.setAttribute("username", username);
				response.sendRedirect("alreadylogin.jsp");
			} else {
				session.setAttribute("login", username);
				response.sendRedirect("admin.jsp");
			}
		} else {
			session.setAttribute("msg", "invalid username or password");
			response.sendRedirect("adminauth.jsp");
		}

	}

	private boolean alreadyLogin(String username) {
		Boolean b = activesessions.add(username);
		if (b) {
			activesessions.add(username);
			return b;
		}

		return false;
	}

	public Set<String> activeSession() {
		return activesessions;
	}

}
