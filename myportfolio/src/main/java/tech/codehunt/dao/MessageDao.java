package tech.codehunt.dao;

import java.util.ArrayList;

import tech.codehunt.pojo.MessagePojo;

public interface MessageDao {

	public String insert(String name, String email, String message);
	public ArrayList<MessagePojo> read();
	public String delete(String sn);
}
