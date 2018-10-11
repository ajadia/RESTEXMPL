package com.wipro.client.messenger.client;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

import com.wipro.mc.resource.GsonMessageBodyHandler;

@Path("secured")
public class SecuredResource extends ResourceConfig{

	@RolesAllowed("CLIENT")
	//@RolesAllowed("ADMIN")
	@GET
	@Path("securedResource")
	@Produces(value = { MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
	public String securedMethod() {

		packages("com.wipro.*");
		register(LoggingFilter.class);
		register(GsonMessageBodyHandler.class);

		// Register Auth Filter here
		register(SecurityFilter.class);
		return "This API is secured";

	}

	
}
