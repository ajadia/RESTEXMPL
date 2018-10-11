package com.wipro.client.messenger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.wipro.client.messenger.database.DatabaseClass;

@XmlRootElement
public class Message {

	private int id;
	private String message;
	private Date created;
	private String author;
	// private Map<Integer, Comment> comments = new HashMap<>();
	private Map<Integer, Comment> comments = DatabaseClass.getComment();
	private List<Link> links = new ArrayList<>();

	// you must have no arg constructor when you need result conversion in any
	// format
	public Message() {
		super();
	}

	public Message(int id, String message, String author) {
		super();
		this.id = id;
		this.message = message;
		this.author = author;
	}

	public Message(int id, String message, String author, Date created) {
		super();
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = created;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	// XmlTransient used because we do not wish to comment data show up when the
	// Message Instance pulled up into the API.
	// So You wants to comments list to be ignored when Message Instance being
	// converted into JSON or XML.

	@XmlTransient
	public Map<Integer, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Integer, Comment> comments) {
		this.comments = comments;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public void addLink(String url, String rel) {
		Link link = new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
	}

}
