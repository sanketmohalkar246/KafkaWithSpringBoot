package com.sanket.kafka.orderProducer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

public class OrderProducer {

	public static void main(String[] args) {

		Properties props = new Properties();
		props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());

		KafkaProducer<String, Integer> producer = new KafkaProducer<String, Integer>(props);
		ProducerRecord<String, Integer> record = new ProducerRecord<String, Integer>("OrderTopic", "Mac book pro", 10);

		try {
			RecordMetadata recordMetadata =  producer.send(record).get();
			//Sync call
			System.out.println(recordMetadata.partition());
			System.out.println(recordMetadata.offset());
			System.out.println("Message Sent!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			producer.close();
		}
	}

}
