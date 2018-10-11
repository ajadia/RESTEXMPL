package com.wipro.client.messenger.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.wipro.client.messenger.model.Message;

public class RestApiClient_webTarget_PostRequest {

	public static void main(String[] args) {
		
		Client client  = ClientBuilder.newClient();
		
		WebTarget baseTarget  =  client.target("http://localhost:8088/jaxrsapp/webapi/");
		WebTarget messageTarget = baseTarget.path("messages");

		/*
		WebTarget singleMessageTarget  = messageTarget.path("{messageId}");
		Message message1 = singleMessageTarget
		.resolveTemplate("messageId", "1")
		.request(MediaType.APPLICATION_JSON)
		.get(Message.class);
		
		Message message2 = singleMessageTarget
		.resolveTemplate("messageId", "2")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		System.out.println("\n "+message1.getAuthor());
		System.out.println("\n "+message2.getAuthor());

		*/
		
		Message newMessage = new Message(6,"My new message from JAX-RS client", "Auther-6 _Ankit Jadia");
				Response postResponse = messageTarget
				.request()
				.post(Entity.json(newMessage));
				//.post(Entity.text(newMessage)); this will give u Exception - MSZBodyWritter not found.
				if(postResponse.getStatus() != 201) 
					System.out.println("\n Erro");
				//System.out.println("Post response: \n "+postResponse+ " post resp details: "+postResponse.readEntity(Message.class));
				Message createdMessage = postResponse.readEntity(Message.class);
				System.out.println("\n "+createdMessage.getMessage());
		
	}

}
