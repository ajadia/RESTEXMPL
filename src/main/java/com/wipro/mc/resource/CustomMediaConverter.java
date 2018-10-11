package com.wipro.mc.resource;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("customMediaConverter")
public class CustomMediaConverter {
	
	
	@GET
	//@Produces("text/shortdate") OR If u have diff version of media type
	@Produces(value = { MediaType.TEXT_PLAIN, "text/shortdate"})
	public Date customShortDate() {
		return Calendar.getInstance().getTime();
	}


}
