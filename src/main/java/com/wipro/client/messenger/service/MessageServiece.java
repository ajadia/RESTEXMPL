package com.wipro.client.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.wipro.client.messenger.database.DatabaseClass;
import com.wipro.client.messenger.exception.DataNotFoundException;
import com.wipro.client.messenger.model.Message;

public class MessageServiece {

	private Map<Integer, Message> messages = DatabaseClass.getMessage();
	Date date = new Date();

	public MessageServiece() {
		messages.put(1, new Message(1, " Rest", "Auther-1"));
		messages.put(2, new Message(2, " Hibernate", "Auther-2"));
		messages.put(3, new Message(3, " Spring", "Auther-3"));
		messages.put(4, new Message(4, " Boot", "Auther-4", date));
		messages.put(5, new Message(5, " Boot", "Auther-5", date));

	}

	public List<Message> getAllMessagesForYear(int year) {

		List<Message> messageForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();

		for (Message message : messages.values()) {
			if("".equals(message.getCreated()) || message.getCreated() == null )
			{
			 //Skip
			}else {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				messageForYear.add(message);
			}}//End else
		}
		return messageForYear;
	}

	public List<Message> getAllMessagePagination(int start, int size) {

		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if (start + size > list.size())
			return new ArrayList<Message>();
		return list.subList(start, start + size);
	}

	public List<Message> getAllMessages() {

		return new ArrayList<Message>(messages.values());

	}

	public Message getMessage(int id) {
		Message message = messages.get(id);
		if(message == null) {
			throw new DataNotFoundException("Message with Id "+id +" not found!!");
		}
		return messages.get(id);
	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		// message.setId(messages.size()+1);
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}

	public Message removeMessage(int id) {
		// message.setId(messages.size()+1);
		return messages.remove(id);

	}
}
