package com.wipro.client.messenger.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.wipro.client.messenger.model.Link;
import com.wipro.client.messenger.model.Message;

public class RestApiClient {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client  = ClientBuilder.newClient();
		Response response  =  client.target("http://localhost:8088/jaxrsapp/webapi/messages/1").request().get();
		Message message = response.readEntity(Message.class);
		List<Link> list = message.getLinks();
		String linkD = "";
		String relD = "";
		for (Link link : list) {
			linkD = link.getLink();
			relD = link.getRel();
			System.out.println(relD+"\t -" );
			System.out.println(linkD+"\n " );
			
		}
		Response response1  =  Response.ok().entity(list).cookie(new NewCookie("cookieResponse", "cookieValueInReturn")).build();
		System.out.println(message.getMessage()+"\n "+linkD +"\n Response : "+response1.getCookies() +"\n Status : "+response1.getStatus()+"\n Headers :"+response1.getHeaders());

	}

}
