package com.wipro.client.messenger.client;



import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class InvocationDemo {

	public static void main(String[] args) {
	
		InvocationDemo classObject = new InvocationDemo();
		Invocation invocation  = classObject.prepareRequestFormessageByYear(2015);
		Response response = invocation.invoke();
		int status_code  = response.getStatus();
		System.out.println("Service returning status code "+status_code);
	
	}

	private Invocation prepareRequestFormessageByYear(int i) {
		Client client = ClientBuilder.newClient();
	
		 return client.target("http://localhost:8088/jaxrsapp/webapi/")
		 //.path("messages/9") // return u 404
		 .path("messages")    //  return u 200
		 .queryParam("year",i)
		 .request(MediaType.APPLICATION_JSON)
		 .buildGet();
		
	}

}
