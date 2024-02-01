package tech.codehunt.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import tech.codehunt.dao.ProjectDaoImpl;

@WebServlet("/Project")
@MultipartConfig
public class Project extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String result;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String check = request.getParameter("check");

		if (check == null) {
			Part part = request.getPart("myfile");
			if(part.getSubmittedFileName() == "") {
				session.setAttribute("msg", "pls upload any file..");
				response.sendRedirect("uploadproject.jsp");
			}
			else {
				String fileName = part.getSubmittedFileName();
				String uniqueFileName = format(fileName);
				result = new ProjectDaoImpl().uploadProject(uniqueFileName,
						request);

				if (result.equals("uploaded")) {
					session.setAttribute("msg", "project uploaded successfully..");
					response.sendRedirect("uploadproject.jsp");
				} else {
					session.setAttribute("msg", "something went wrong..");
					response.sendRedirect("uploadproject.jsp");
				}
			}
		}
		
		else if(check.equals("deleteproject")) {
			//delete project logic
			String sn = request.getParameter("sn");
			String filename = request.getParameter("filename");
			result = new ProjectDaoImpl().deleteProject(filename, sn, request);
		
			if (result.equals("deleted")) {
				session.setAttribute("msg", "project deleted successfully..");
				response.sendRedirect("deleteproject.jsp");
			} else {
				session.setAttribute("msg", "something went wrong..");
				response.sendRedirect("deleteproject.jsp");
			}
		}

	}

	private String format(String fileName) {
		String format = LocalDateTime.now().toString();

		String[] split = format.split(":");

		String unique = split[0] + split[1] + split[2] + fileName;

		return unique;
	}

}
