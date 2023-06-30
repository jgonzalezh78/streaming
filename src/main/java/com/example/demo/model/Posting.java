package com.example.demo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data; 

@Data
@AllArgsConstructor
@Document(collection = "posting")
public class Posting {
	
	@Id
	private String id;
	private String create_request_id;
	private String client_batch_id;
	private String response;
	private String arrival_posting;
		
}
