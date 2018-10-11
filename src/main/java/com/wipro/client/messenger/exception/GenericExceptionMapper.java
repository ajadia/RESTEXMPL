package com.wipro.client.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.wipro.client.messenger.model.ErrorMessage;

//Every exception mapper in JAX-RS needs to implement Exception Mapper class from core package. Initially it's raw type 
// so we needs it to be generic type to the exception, that we wants to handle i.e. Data Not Found Exception
//We must needs to annotate (by @Provider) are class to register with JAX-RS, so it knows (By searching all the mapper) to handle DNF exception.

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {
		// TODO Auto-generated method stub - Here we can cath the exception and prepare
		// the msz, response and send it back to user.
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 500, "https://ankitjadia.org");

		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
	}

}
