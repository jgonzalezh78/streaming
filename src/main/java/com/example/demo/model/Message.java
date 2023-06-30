package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data; 

@Data
@AllArgsConstructor
@Document(collection = "message")
public class Message {
	
	@Id
	private String id;
	private String message;
	private String create_request_id;
		
}
