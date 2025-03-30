package com.sanket.kafka.springKafkaDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanket.kafka.springKafkaDemo.service.UserProducerService;

@RestController
@RequestMapping("/userapi")
public class UserController {

	@Autowired
	private UserProducerService userProducerService;

	@PostMapping("/publishUserData/{name}/{age}")
	public void sendUserData(@PathVariable("name") String name, @PathVariable("age") Integer age) {
		userProducerService.sendUserdata(name, age);
	}
}
