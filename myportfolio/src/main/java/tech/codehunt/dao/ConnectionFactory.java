package tech.codehunt.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnectionFactory {
	
	private static Connection con;
	
	@SuppressWarnings("finally")
	public static Connection getConnection() {
		
		MysqlDataSource ds = new MysqlDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/myportfolio_codehunt");
		ds.setUser("root");
		ds.setPassword("HAIDAR@a123");
		
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			return con;
		}
	}

}
