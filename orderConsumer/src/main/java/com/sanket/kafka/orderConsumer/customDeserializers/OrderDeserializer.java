package com.sanket.kafka.orderConsumer.customDeserializers;

import java.io.IOException;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OrderDeserializer implements Deserializer<Order> {

	public Order deserialize(String topic, byte[] data) {

		ObjectMapper objectmapper = new ObjectMapper();
		Order order = null;
		try {
			order = objectmapper.readValue(data, Order.class);
		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return order;
	}

}
