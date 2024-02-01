package tech.codehunt.dao;

import java.sql.Connection;


public class Create {

	private Connection con;
	private String sql;
	public void createProjectTable() {
		try {
			con = ConnectionFactory.getConnection();
			sql = "create table project(sn int primary key auto_increment,"
					+ "filename varchar(100))";
			con.createStatement().execute(sql);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void dropEducationTable() {
		try {
			con = ConnectionFactory.getConnection();
			sql = "create table project(sn int primary key auto_increment,"
					+ "filename varchar(100))";
			con.createStatement().execute(sql);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
