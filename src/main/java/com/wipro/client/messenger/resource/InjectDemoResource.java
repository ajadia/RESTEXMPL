package com.wipro.client.messenger.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectDemo")

@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	@GET
	@Path("annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
											@HeaderParam("authSessionId") String customHeaderValue,
											@CookieParam("cookieParam") String cookieParam
			) {
		//We can use matrix param like quaryparam by using ";" in URL. ***/annotations;param=value
		return "Matrix param: "+matrixParam +" Header Param: "+customHeaderValue +" Cookie Param : "+cookieParam;
	}
	
	@GET
	@Path("context")
	public String getAllParamUsingContex(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
		
		String fullPath = uriInfo.getAbsolutePath().toString();
		String header = headers.getCookies().toString();
		return "Path: "+fullPath+ "header Cookies: "+header;
	}
	
	
	
}
