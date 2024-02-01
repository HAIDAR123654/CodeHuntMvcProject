package tech.codehunt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import tech.codehunt.pojo.MessagePojo;

public class MessageDaoImpl implements MessageDao{
	
	private String sql;
	private Connection con;
	private PreparedStatement ps;
	private String result;
	private int row;
	private ResultSet rs;

	@SuppressWarnings("finally")
	@Override
	public String insert(String name, String email, String message) {
		
		try {
			con = ConnectionFactory.getConnection();
			sql = "insert into message(name,email,message) values(?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, message);
			
			row = ps.executeUpdate();
			if(row == 1) {
				result = "saved";
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			result = "failed";
		}
		finally {
			return result;
		}
		
	}

	@SuppressWarnings("finally")
	@Override
	public ArrayList<MessagePojo> read() {
		ArrayList<MessagePojo> arrayList = new ArrayList<MessagePojo>();
		try {
			con = ConnectionFactory.getConnection();
			sql = "select * from message";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int getsn = rs.getInt("sn");
				String getname = rs.getString("name");
				String getemail = rs.getString("email");
				String getmessage = rs.getString("message");
				MessagePojo messagePojo = new MessagePojo(getsn, getname, getemail, getmessage);
			    arrayList.add(messagePojo);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			return arrayList;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public String delete(String sn) {
		
		try {
			con = ConnectionFactory.getConnection();
			sql = "delete from message where sn=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(sn));
			row = ps.executeUpdate();
			if(row==1) {
				result = "deleted";
			}
		
		}
		catch(Exception ex) {
			ex.printStackTrace();
			result = "failed";
		}
		finally {
			return result;
		}
	}

}
