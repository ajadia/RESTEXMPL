package com.wipro.mc.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("date/{datestring}")
public class CustomParamConverter_Resource {

@GET
@Produces(MediaType.TEXT_PLAIN)
public String getDateInstance(@PathParam("datestring") CustomParamConverter datestring) {
	
	return "Got it !! "+datestring.toString();
}

}
