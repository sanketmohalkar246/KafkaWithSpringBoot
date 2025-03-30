package com.sanket.kafka.springKafkaDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.sanket.kafka.springKafkaDemo.Dto.User;

@Service
public class UserProducerService {
	
	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;
	
	public void sendUserdata(User user) {
		kafkaTemplate.send("user-topic", user.getName(), user);
	}

}
