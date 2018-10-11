package com.wipro.client.messenger.client;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

import com.wipro.client.messenger.exception.DataNotFoundException;
import com.wipro.client.messenger.exception.GenericExceptionMapper;

@Provider
public class SecurityFilter implements ContainerRequestFilter {

	@Context
	private ResourceInfo resourceInfo;

	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	private static final String SECURED_URI_PREFIX = "secured";

	private static final Response ACCESS_DENIED = Response.status(Response.Status.UNAUTHORIZED)
			.entity("You cannot access this resource").build();
	private static final Response ACCESS_FORBIDDEN = Response.status(Response.Status.FORBIDDEN)
			.entity("Access blocked for all users !!").build();

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("Log 1");
		if (requestContext.getUriInfo().getPath().contains(SECURED_URI_PREFIX)) {
			System.out.println("Log 2");

			Method method = resourceInfo.getResourceMethod();
			try {

				// Access allowed for all
				if (!method.isAnnotationPresent(PermitAll.class)) {
					// Access denied for all
					if (method.isAnnotationPresent(DenyAll.class)) {
						requestContext.abortWith(ACCESS_FORBIDDEN);
						return;
					}

					List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);

					if (authHeader != null && authHeader.size() > 0) {
						System.out.println("Log 3");
						System.out.println("Log 3.1 : " + authHeader);

						String authToken = authHeader.get(0);
						System.out.println("Log 3.1.0 : authToken " + authToken);
						authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
						String decodedString = Base64.decodeAsString(authToken);
						System.out.println("Log 3.2 Token after replace First: " + authToken);
						System.out.println("Log 3.2.1 decodedString-> " + decodedString);
						StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
						System.out.println("Log 3.3 Tokenizer: " + tokenizer);

						String username = tokenizer.nextToken();
						String password = tokenizer.nextToken();

						// Verify user access
						if (method.isAnnotationPresent(RolesAllowed.class)) {
							RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
							Set<String> rolesSet = new HashSet<String>(Arrays.asList(rolesAnnotation.value()));

							// Is user valid?
							if (!isUserAllowed(username, password, rolesSet)) {
								Response unAuthorizedStatus = Response.status(Status.NOT_FOUND).entity("User role is not valid.").build();
								System.out.println("Log 5: " + unAuthorizedStatus);
								requestContext.abortWith(unAuthorizedStatus);
								
								return;
							}
						} else {
							requestContext.abortWith(ACCESS_DENIED);
							return;
						}
					} else if (authHeader == null || authHeader.isEmpty()) {
						requestContext.abortWith(ACCESS_DENIED);
						return;
					}

				} else {
					Response unAuthorizedStatus = Response.status(Response.Status.UNAUTHORIZED)
						.entity("user can't access the resource. ").build();
					System.out.println("Log 5: " + unAuthorizedStatus);
					requestContext.abortWith(unAuthorizedStatus);
				}

			} catch (Exception e) {
				System.out.println("Log 6");
				e.printStackTrace();
			}
		}

	}

	private boolean isUserAllowed(final String username, final String password, final Set<String> rolesSet) {
		boolean isAllowed = false;

		// Step 1. Fetch password from database and match with password in argument
		// If both match then get the defined role for user from database and continue;
		// else return isAllowed [false]
		// Access the database and do this part yourself
		// String userRole = userMgr.getUserRole(username);

		if (username.equals("ankit") && password.equals("ankit")) {
			String userRole = "ADMIN";

			// Step 2. Verify user role
			if (rolesSet.contains(userRole)) {
				isAllowed = true;
			}
		}
		return isAllowed;
	}

}
