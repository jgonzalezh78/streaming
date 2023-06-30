package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.Posting;


public interface PostingRepository extends MongoRepository<Posting, String> {
	 

}
