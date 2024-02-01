package tech.codehunt.controller;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Resume")
public class Resume extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "D:\\JavaMvcProject\\myportfolio\\src\\main\\webapp\\myresume\\Report.pdf";
		
//		String path = request.getRealPath("myresume/myresume.pdf");
		
		FileInputStream fis = new FileInputStream(path);
		
		byte b[] = new byte[fis.available()];
		fis.read(b);
		
		ServletOutputStream os = response.getOutputStream();
		response.setHeader("content-disposition", "filename=myresume.pdf");
		response.setContentType("application/octet-stream"); //global file type
	
		os.write(b);
	
		fis.close();
		os.close();
	}

}
