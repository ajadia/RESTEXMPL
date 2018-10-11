package com.wipro.client.messenger.model;

public class Link {

// The goal is to create navigation links in output, so that a user can further navigate to the different options. 	
// For this we are modifying MR.java 
	
	private String link;
	private String rel;
	public String getLink() {
		return link;
	}
	public String getRel() {
		return rel;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	
}
