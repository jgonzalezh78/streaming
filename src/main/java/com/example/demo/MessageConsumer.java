package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.model.Message;
import com.example.demo.repository.MessageRepository;

@Service
public class MessageConsumer {

	@Autowired
	private MessageRepository messageRepository;


	@KafkaListener(topics = "messagetopic",groupId = "group_id")
	public void consumeMessage(String message) {

		System.out.println("Mensaje consumido de topico kafka " + message);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("objet posting "+message.toString());
		Message messageObject = new Message(UUID.randomUUID().toString(), message, format.format((new Date().getTime())));
		messageRepository.save(messageObject);
	}

}