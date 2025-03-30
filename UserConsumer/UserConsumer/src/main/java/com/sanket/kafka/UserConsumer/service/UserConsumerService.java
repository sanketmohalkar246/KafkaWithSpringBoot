package com.sanket.kafka.UserConsumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.sanket.kafka.springKafkaDemo.Dto.User;


@Service
public class UserConsumerService {
	
	@KafkaListener(topics = {"user-topic"})
	public void consumeUserData(User user) {
		System.out.println("User name :" + user.getName());
		System.out.println("User age: "+ user.getAge());
		System.out.println("User add :" + user.getAdd());
	}

}
