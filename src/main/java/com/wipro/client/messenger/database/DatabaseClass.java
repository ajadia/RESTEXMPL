package com.wipro.client.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.wipro.client.messenger.model.Comment;
import com.wipro.client.messenger.model.Message;
import com.wipro.client.messenger.model.Profile;

public class DatabaseClass {
	
	
	private static Map<Integer,Message> message = new HashMap<>();
	private static Map<String,Profile> profiles = new HashMap<>();
	private static Map<Integer,Comment> comment = new HashMap<>();
	
	
	public static Map<Integer, Message> getMessage() {
		return message;
	}
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	public static Map<Integer, Comment> getComment(){
		return comment;
	}
	

}
