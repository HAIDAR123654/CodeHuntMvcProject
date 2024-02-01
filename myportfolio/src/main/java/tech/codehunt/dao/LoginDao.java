package tech.codehunt.dao;

import tech.codehunt.pojo.ReadLoginPojo;

public interface LoginDao {
	
	public String checkCredentials(String username, String password);

	public ReadLoginPojo readLogin();
	
	public String updateLoginInfo(String username, String password);
}
