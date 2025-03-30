package com.sanket.kafka.orderConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class OrderConsumer {

	public static void main(String[] args) {

		  Properties props = new Properties();
	        props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	        props.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
	        props.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class.getName());
	        props.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "orderGroup");
	
	        
	        KafkaConsumer<String, Integer> consumer = new KafkaConsumer<String, Integer>(props);
	        consumer.subscribe(Collections.singletonList("OrderTopic"));
	        
	      ConsumerRecords<String, Integer> orders =  consumer.poll(Duration.ofSeconds(20));
	      for(ConsumerRecord<String, Integer> order: orders) {
	    	  System.out.println("Producet name :" + order.key());
	    	  System.out.println("Quantity :" + order.value());
	      }
	      
	      consumer.close();
	      
	}

}
