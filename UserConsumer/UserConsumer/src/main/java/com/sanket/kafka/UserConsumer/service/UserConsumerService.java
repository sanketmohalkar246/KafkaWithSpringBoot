package com.sanket.kafka.UserConsumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumerService {
	
	@KafkaListener(topics = {"user-topic"})
	public void consumeUserData(Integer age) {
		System.out.println(age);
	}

}
