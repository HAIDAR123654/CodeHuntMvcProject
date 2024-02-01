package tech.codehunt.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.MysqlDataSource;


public class Employee extends HttpServlet {
	
	private Connection con;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eid = request.getParameter("eid");
		String ename = request.getParameter("ename");
		String eaddress = request.getParameter("eaddress");
		String esalary = request.getParameter("esalary");
		
		System.out.println(eid + ":" + ename + ":" + eaddress + ":" + esalary);
		
		MysqlDataSource ds = new MysqlDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/Employee_codehunt");
		ds.setUser("root");
		ds.setPassword("HAIDAR@a123");
		
		try {
			con = ds.getConnection();
			String sql = "insert into Employee(eid, ename, eaddress,esalary) values(?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(eid));
			ps.setString(2, ename);
			ps.setString(3, eaddress);
			ps.setInt(4, Integer.parseInt(esalary));
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
