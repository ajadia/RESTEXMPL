package com.wipro.mc.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Provider
@Consumes(MediaType.APPLICATION_JSON)

public class MessageBodyReader_EmpType implements MessageBodyReader<Employee> {

	
	 private static final String UTF_8 = "UTF-8";
	  private Gson gson;
	  private Gson getGson() {
	    if (gson == null) {
	      final GsonBuilder gsonBuilder = new GsonBuilder();
	      gson = gsonBuilder.create();
	    }
	    System.out.println(" gson: "+ gson.getClass());
	    return gson;
	  } 
	  
	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// return type == Employee.class;
		System.out.println(" isReadable: "+ Employee.class.isAssignableFrom(type));
		return Employee.class.isAssignableFrom(type);
	}

	@Override
	public Employee readFrom(Class<Employee> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {
		
		 InputStreamReader streamReader = new InputStreamReader(entityStream, UTF_8);
		    try {
		      Type jsonType;
		      if (type.equals(genericType)) {
		        jsonType = type;
		      } else {
		        jsonType = genericType;
		      }
		      return getGson().fromJson(streamReader, jsonType);
		    } finally {
		      streamReader.close();
		    }

	}

}
