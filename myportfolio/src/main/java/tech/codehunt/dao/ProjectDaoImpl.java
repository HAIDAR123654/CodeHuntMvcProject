package tech.codehunt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import tech.codehunt.fileio.ProjectIO;
import tech.codehunt.pojo.ProjectPojo;

public class ProjectDaoImpl implements ProjectDao {

	private String sql;
	private Connection con;
	private PreparedStatement ps;
	private String result;
	private int row;
	private ResultSet rs;

	@SuppressWarnings("finally")
	@Override
	public String uploadProject(String uniqueFileName, HttpServletRequest req) {

		try {
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			sql = "insert into project(filename) values(?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, uniqueFileName);
			row = ps.executeUpdate();

			if (row == 1) {
                result = new ProjectIO().projectWrite(req, uniqueFileName);
                if(result.equals("success")) {
                	con.commit();
                	result = "uploaded";
                }
                else {
                	con.rollback();
                	result = "failed";
                }
			}

		} catch (Exception ex) {
			result = "failed";
			ex.printStackTrace();
			
		} finally {
			return result;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public ArrayList<ProjectPojo> readProject() {
		ArrayList<ProjectPojo> arrayList = new ArrayList<ProjectPojo>();
		try {
			con = ConnectionFactory.getConnection();
			sql = "select * from project";
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ProjectPojo p = new ProjectPojo(rs.getInt("sn"), rs.getString("filename"));
				arrayList.add(p);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			
		} finally {
			return arrayList;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public String deleteProject(String fileName, String sn,
			HttpServletRequest request) {
		
		try {
			con = ConnectionFactory.getConnection();
			con.setAutoCommit(false);
			sql = "delete from project where sn=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(sn));
			row = ps.executeUpdate();
			
			if(row == 1) {
				result = new ProjectIO().projectDelete(request, fileName);
				if(result.equals("success")) {
					con.commit();
					result = "deleted";
				}
				else {
					con.rollback();
					result = "notdeleted";
				}
			}
			

		} catch (Exception ex) {
			result = "notdeleted";
			ex.printStackTrace();
			
		} finally {
			return result;
		}
	}

}
