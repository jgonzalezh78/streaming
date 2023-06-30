package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.model.Posting;
import com.example.demo.repository.PostingRepository;
import com.google.gson.Gson;

@Service
public class PostingConsumer {

	@Autowired
	private PostingRepository postingRepository;

	@KafkaListener(topics = "", groupId = "group_id")
	public void consumeJSONMessage(String message) {
		System.out.println("Mensaje consumido de topico kafka " + message);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String postingString = message;
		Gson gson = new Gson();
		Posting posting = gson.fromJson(postingString, Posting.class);
		posting.setId(posting.getId() + "-" + new Date().getTime());
		posting.setResponse(postingString);
		posting.setArrival_posting(format.format(new Date()));
		// System.out.println("objet posting "+posting.toString());
		postingRepository.save(posting);

	}

}