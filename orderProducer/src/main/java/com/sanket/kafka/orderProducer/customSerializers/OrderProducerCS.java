package com.sanket.kafka.orderProducer.customSerializers;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

public class OrderProducerCS {

	public static void main(String[] args) {

		Properties props = new Properties();
		props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				"com.sanket.kafka.orderProducer.customSerializers.OrderSerializer");

		KafkaProducer<String, Order> producer = new KafkaProducer<String, Order>(props);
		Order order = new Order();
		order.setCustomerName("SanketMohalkar");
		order.setProduct("Pixel");
		order.setQuantity(1);
		ProducerRecord<String, Order> record = new ProducerRecord<String, Order>("OrderCSTopic", order.getCustomerName(),
				order);

		try {

			producer.send(record);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			producer.close();
		}
	}

}
