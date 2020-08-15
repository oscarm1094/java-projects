package com.oscar.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.oscar.model.Message;
import com.oscar.service.MessageService;

@Named
@RequestScoped
public class MessageControler {

	private Message message = new Message();
	private List<Message> messages;

	@Inject
	private MessageService messageService;

	@PostConstruct
	public void init() {
		messages = messageService.list();
	}

	public void submit() {
		messageService.create(message);
		messages.add(message);
	}

	// note that you don't need setters for message and messages. We're going to use
	// the
	// getters and setters of the Message entity itself
	public Message getMessage() {
		return message;
	}

	public List<Message> getMessages() {
		return messages;
	}

}
