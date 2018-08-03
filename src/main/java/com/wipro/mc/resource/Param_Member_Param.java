package com.wipro.mc.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("{pathParam}/pathParamEx")
public class Param_Member_Param {


@PathParam("pathParam") private String pathparam;
@QueryParam("queryparam") private String queryparam;
@QueryParam("queryparam1") private String queryparam1;


@GET
@Produces(MediaType.TEXT_PLAIN)
public String pathAndMemberParamAccess() {
	
	return "Works Well !! Value of path param is "+pathparam +" and Query param is "+queryparam +"\n  and Query param1 is "+ queryparam1;
}


}
