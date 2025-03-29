package com.sanket.kafka.orderConsumer.customDeserializers;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class OrderConsumerCS {

	public static void main(String[] args) {

		  Properties props = new Properties();
	        props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	        props.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
	        props.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, OrderDeserializer.class.getName());
	      //props.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "com.sanket.kafka.orderConsumer.customDeserializers.OrderDeserializer");
	        props.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "orderGroup");
	
	        
	        KafkaConsumer<String, Order> consumer = new KafkaConsumer<String, Order>(props);
	        consumer.subscribe(Collections.singletonList("OrderCSTopic"));
	        
	      ConsumerRecords<String, Order> orders =  consumer.poll(Duration.ofSeconds(30));
	      for(ConsumerRecord<String, Order> record: orders) {
	    	  System.out.println("Customer name :" + record.key());
	    	  Order order = record.value();
	    	  if(order!=null) {
	    	  System.out.println("Product :" + order.getProduct());
	    	  System.out.println("Quantity :" + order.getQuantity());}
	      }
	      
	      consumer.close();
	      
	}

}
