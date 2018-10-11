package com.wipro.client.messenger.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.wipro.client.messenger.model.Message;

public class RestApiClient_webTarget_GetRequest {

	public static void main(String[] args) {
		
		Client client  = ClientBuilder.newClient();
		
		WebTarget baseTarget  =  client.target("http://localhost:8088/jaxrsapp/webapi/");
		WebTarget messageTarget = baseTarget.path("messages");
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

	}

}
