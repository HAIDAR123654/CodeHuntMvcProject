package tech.codehunt.dao;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import tech.codehunt.pojo.ProjectPojo;

public interface ProjectDao {
	
	public String uploadProject(String uniqueFileName, HttpServletRequest req);
	
	public ArrayList<ProjectPojo> readProject();
	
	public String deleteProject(String fileName, String sn, HttpServletRequest request);

}
