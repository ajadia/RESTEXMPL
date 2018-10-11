package com.wipro.client.messenger.model;

import java.util.Date;

public class Comment {

	private int comment_id;
	private String comment_message;
	private Date comment_created;
	private String comment_author;
	
	
	
	public Comment(int comment_id, String comment_message, Date comment_created, String comment_author) {
		super();
		this.comment_id = comment_id;
		this.comment_message = comment_message;
		this.comment_created = comment_created;
		this.comment_author = comment_author;
	}



	public Comment() {
		super();
	}



	public int getComment_id() {
		return comment_id;
	}



	public String getComment_message() {
		return comment_message;
	}



	public Date getComment_created() {
		return comment_created;
	}



	public String getComment_author() {
		return comment_author;
	}



	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}



	public void setComment_message(String comment_message) {
		this.comment_message = comment_message;
	}



	public void setComment_created(Date comment_created) {
		this.comment_created = comment_created;
	}



	public void setComment_author(String comment_author) {
		this.comment_author = comment_author;
	}
		
}
