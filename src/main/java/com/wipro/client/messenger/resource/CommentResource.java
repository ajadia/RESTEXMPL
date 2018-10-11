package com.wipro.client.messenger.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.wipro.client.messenger.model.Comment;
import com.wipro.client.messenger.service.CommentService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class CommentResource {
	// Note that you can access parent path resources into child resource.

	CommentService commentService = new CommentService();

	/**
	 * MessageServiece service = new MessageServiece();
	 * 
	 * @GET public List<Message> getAllComments() { return (List<Message>)
	 *      service.getAllMessages(); }
	 * @GET @Path("/{commentId}") public String
	 *      getCommentId( @PathParam("messageId") String
	 *      messageId,@PathParam("commentId") String commentId) { return "Method
	 *      returning parent message Id "+ messageId+ " and sub Id Comment Id :
	 *      "+commentId; }
	 **/

	@GET
	public List<Comment> getAllComments(@PathParam("messageId") int messageid) {

		return commentService.getAllComments(messageid);
	}

	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam("messageId") int messageid, @PathParam("commentId") int commentid) {

		return commentService.getComment(messageid, commentid);
	}

	@POST
	public Comment addComment(@PathParam("messageId") int messageid, Comment comment) {

		return commentService.addComment(messageid, comment);
	}

	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") int messageid, @PathParam("commentId") int commentid,
			Comment comment) {

		if (commentid <= 0) {
			return null;
		} else {
			comment.setComment_id(commentid);
			return commentService.updateComment(messageid, comment);
		}
	}

	@DELETE
	@Path("/{commentId}")
	public Comment removeComment(@PathParam("messageId") int messageid, @PathParam("commentId") int commentid) {
		commentService.removeComment(messageid, commentid);
		return null;
	}
}
