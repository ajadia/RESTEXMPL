package com.wipro.client.messenger.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.wipro.client.messenger.model.Message;

public class GenericExample {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();
		List<Message> messagesList = client
				.target("http://localhost:8088/jaxrsapp/webapi/")
				.path("messages")
				//.queryParam("year", 2010)
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Message>>() {
				});
		System.out.println(messagesList);

	}

}
