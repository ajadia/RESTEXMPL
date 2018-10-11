package com.wipro.client.messenger.resource;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.wipro.client.messenger.model.Message;
import com.wipro.client.messenger.resource.bean.MessageFilterBean;
import com.wipro.client.messenger.service.MessageServiece;
import com.wipro.mc.resource.Employee;

@Path("/messages")
public class MessageResource {

	MessageServiece messageService = new MessageServiece();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAllMessages(@BeanParam MessageFilterBean filterBean) {
		if (filterBean.getYear() > 0) {
			return messageService.getAllMessagesForYear(filterBean.getYear());
		}

		if (filterBean.getStart() > 0 && filterBean.getStart() > 0) {

			return messageService.getAllMessagePagination(filterBean.getStart(), filterBean.getSize());
		}
	    
		return messageService.getAllMessages();
	}
	/*
	 * public List<Message> getAllMessages(@QueryParam("year") int year,
	 * 
	 * @QueryParam("start") int start,
	 * 
	 * @QueryParam("size") int size) { if(year > 0) { return
	 * messageService.getAllMessagesForYear(year); }
	 * 
	 * if(start >= 0 && size >= 0) {
	 * 
	 * return messageService.getAllMessagePagination(start, size); } return
	 * messageService.getAllMessages(); }
	 */

	/*
	 * comments for Hateoas practice:To provide links in output
	 * 
	 * @GET
	 * 
	 * @Path("/{messageId}")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public Message
	 * getMessages(@PathParam("messageId") int messageId) { return
	 * messageService.getMessage(messageId); }
	 */

	
	// HATEOAS Example
	@GET
	@Path("/{messageId}")
	@Produces(value= {MediaType.APPLICATION_JSON, MediaType.TEXT_XML} )
	public Message getMessages(@PathParam("messageId") int messageId, @Context UriInfo uriInfo) {
		Message message = messageService.getMessage(messageId);
		message.addLink(getUriForSelf(uriInfo, message), "self");
		message.addLink(getUriForProfile(uriInfo, message), "profile");
		message.addLink(getUriForComment(uriInfo, message), "comment");
		return message;
	}

	private String getUriForComment(UriInfo uriInfo, Message message) {
		
		URI uri = uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
				.path(MessageResource.class, "getCommentResource")
				.resolveTemplate("messageId", message.getId())
				.path(CommentResource.class)
				.build();
				
		return uri.toString();
	}
	private String getUriForProfile(UriInfo uriInfo, Message message) {
		String uri = uriInfo.getBaseUriBuilder() // http://localhost:8080/messenger/webapi/
				.path(ProfileResource.class) // messages
				.path(message.getAuthor()).build().toString();
		return uri;
		
	}
	private String getUriForSelf(UriInfo uriInfo, Message message) {
		String uri = uriInfo.getBaseUriBuilder() // http://localhost:8080/messenger/webapi/
				.path(MessageResource.class) // messages
				.path(Integer.toString(message.getId())).build().toString();
		return uri;
	}

	/*
	 * @POST
	 * 
	 * @Produces(MediaType.APPLICATION_JSON)
	 * 
	 * @Consumes(MediaType.APPLICATION_JSON) public Message addMessage(Message
	 * message) { return messageService.addMessage(message); }
	 */

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		Message newMessage = messageService.addMessage(message);
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();

		return Response.created(uri).entity(newMessage).build();

	}

	@PUT
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") int messageId, Message message) {
		message.setId(messageId);
		return messageService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteMessage(@PathParam("messageId") int messageId) {
		messageService.removeMessage(messageId);
		return "Message Deleted Successfully";
	}

	// Notice that below method is not for direct call but it's used for invoking
	// child resource. so "DO NOT ADD GET POST OR PUT " anno.
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();

	}

}
