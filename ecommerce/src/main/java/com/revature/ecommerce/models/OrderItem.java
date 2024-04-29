package com.revature.ecommerce.models;

import java.util.UUID;

public class OrderItem {
private String id;
private String orderId;
private String productId;
private int productQuantity;
private double price;
public OrderItem() {
	this.id = UUID.randomUUID().toString();
	
}
public OrderItem(String orderId, String productId, int productQuantity, double price) {
	super();
	this.id = UUID.randomUUID().toString();
	this.orderId = orderId;
	this.productId = productId;
	this.productQuantity = productQuantity;
	this.price = price;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getOrderId() {
	return orderId;
}
public void setOrderId(String orderId) {
	this.orderId = orderId;
}
public String getProductId() {
	return productId;
}
public void setProductId(String productId) {
	this.productId = productId;
}
public int getProductQuantity() {
	return productQuantity;
}
public void setProductQuantity(int productQuantity) {
	this.productQuantity = productQuantity;
}
public double getPrice() {
	return price;
}
public void setPrice(double productTotal) {
	this.price = productTotal;
}


}
