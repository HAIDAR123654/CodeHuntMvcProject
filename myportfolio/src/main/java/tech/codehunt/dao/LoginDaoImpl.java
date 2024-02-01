package tech.codehunt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import tech.codehunt.pojo.ReadLoginPojo;

public class LoginDaoImpl implements LoginDao{

	private String sql;
	private Connection con;
	private PreparedStatement ps;
	private String result;
	private ResultSet rs;
	private int row;
	
	@SuppressWarnings("finally")
	@Override
	public String checkCredentials(String username, String password) {
		
		try {
			con = ConnectionFactory.getConnection();
			sql = "select * from login where username=? and password=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				result = "exist";
			}
			else {
				result="notexist";
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			result="notexist";
		}
		finally {
			return result;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public ReadLoginPojo readLogin() {
		ReadLoginPojo rlp = null;
		try {
			con = ConnectionFactory.getConnection();
			sql = "select * from login where sn=1";
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			rs.next();
			
			rlp = new ReadLoginPojo(rs.getString("username"), rs.getString("password"));
		}
		catch(Exception ex) {
			ex.printStackTrace();
			result="notexist";
		}
		finally {
			return rlp;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public String updateLoginInfo(String username, String password) {
		try {
			con = ConnectionFactory.getConnection();
			sql = "update login set username=?, password=? where sn=1";
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			row = ps.executeUpdate();
			if(row == 1) {
				result = "updated";
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
			result="failed";
		}
		finally {
			return result;
		}
	}

}
