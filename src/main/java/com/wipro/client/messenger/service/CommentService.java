package com.wipro.client.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.wipro.client.messenger.database.DatabaseClass;
import com.wipro.client.messenger.model.Comment;
import com.wipro.client.messenger.model.Message;

public class CommentService {

	private Map<Integer, Message> messages = DatabaseClass.getMessage();
	private Map<Integer, Comment> comments = DatabaseClass.getComment();
    Date date = new Date(); 
	
	
	
	public CommentService() {
		comments.put(1, new Comment(1, " comment 1",date,"Ankit's comment 1"));
		comments.put(2, new Comment(2, " comment 2",date,"Nikhil's comment 2"));
		comments.put(3, new Comment(3, " comment 3",date,"Ravi's comment 3"));
		comments.put(4, new Comment(4, " comment 4",date,"Kumar's comment 4"));
		comments.put(5, new Comment(5, " comment 5",date,"prince comment 5"));
		
	}

	public List<Comment> getAllComments(int messageId) {

		Map<Integer, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}

	public Comment getComment(int messageId, int commentId) {

		Map<Integer, Comment> comment1 = messages.get(messageId).getComments();
		return comment1.get(commentId);

	}

	public Comment addComment(int messageid, Comment comment) {
		if (messageid <= 0)
			return null;
		Map<Integer, Comment> comments = messages.get(messageid).getComments();
		comment.setComment_id(comments.size() + 1);
		comments.put(comment.getComment_id(), comment);
		return comment;

	}

	public Comment updateComment(int messageId, Comment comment) {
		if (comment.getComment_id() <= 0 || messageId <= 0) {
			return null;
		} else {
			Map<Integer, Comment> comments = messages.get(messageId).getComments();
			comments.put(comment.getComment_id(), comment);
			return comment;
		}
	}

	public Comment removeComment(int messageid, int commentid) {
		if (commentid <= 0 || messageid <= 0) {
			return null;
		} else {
			Map<Integer, Comment> comments = messages.get(messageid).getComments();
			return comments.remove(commentid);

		}

			
	}
}
