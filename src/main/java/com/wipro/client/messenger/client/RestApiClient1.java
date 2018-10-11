package com.wipro.client.messenger.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class RestApiClient1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client  = ClientBuilder.newClient();
//		Message message  =  client.target("http://localhost:8088/jaxrsapp/webapi/messages/1")
//				.request(MediaType.APPLICATION_JSON)
//				.get(Message.class);
//		//Message message = response.readEntity(Message.class);  OR
		//System.out.println(message.getAuthor()+"\n ");
		String message  =  client.target("http://localhost:8088/jaxrsapp/webapi/messages/1")
				.request(MediaType.APPLICATION_JSON)
				.get(String.class);
		
		System.out.println(message+"\n ");

	}

}
