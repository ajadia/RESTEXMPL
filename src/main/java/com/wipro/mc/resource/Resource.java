package com.wipro.mc.resource;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("resource")
@Singleton
public class Resource {

	private int count;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String simpleTestResource() {
		count = count +1;
		return "If Singleton - instance created only once !! this method is called "+count +" time(s).";
	}
	
	
	
	
	

}
