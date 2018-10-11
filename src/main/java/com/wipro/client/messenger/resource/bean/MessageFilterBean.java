package com.wipro.client.messenger.resource.bean;

import javax.ws.rs.QueryParam;

public class MessageFilterBean {
	
	
	//3 member variable in the class.
	private @QueryParam("year") int year;
	private @QueryParam("start") int start;
	private @QueryParam("size") int size;
	public int getYear() {
		return year;
	}
	public int getStart() {
		return start;
	}
	public int getSize() {
		return size;
	}
	

	//Check Bean annotation use in Messageresource.java
	
	
}
