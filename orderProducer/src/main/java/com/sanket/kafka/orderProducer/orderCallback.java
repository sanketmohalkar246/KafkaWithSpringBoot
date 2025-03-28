package com.sanket.kafka.orderProducer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

public class orderCallback implements Callback {

	public void onCompletion(RecordMetadata metadata, Exception exception) {
		System.out.println(metadata.partition());
		System.out.println(metadata.offset());
		System.out.println("Message Sent!");
		if(exception!=null) {
			exception.printStackTrace();
		}
	}

}
