package com.sanket.kafka.orderConsumer.customDeserializers;

import java.io.Serializable;

public class Order implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String customerName;
	private String product;
	private int quantity;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
