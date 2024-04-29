package com.revature.ecommerce.dto.responses;

import java.util.List;

import com.revature.ecommerce.models.OrderItem;

public class OrderCartResponse {
private String id;
 private String uId;
 private String order_id;
 private List<OrderItem> items;
 private double total;
 private int quantity;
public OrderCartResponse() {
	super();
	// TODO Auto-generated constructor stub
}
public OrderCartResponse(String id, String uId, String order_id, List<OrderItem> items, double total, int quantity) {
	super();
	this.id = id;
	this.uId = uId;
	this.order_id = order_id;
	this.items = items;
	this.total = total;
	this.quantity = quantity;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getuId() {
	return uId;
}
public void setuId(String uId) {
	this.uId = uId;
}
public String getOrder_id() {
	return order_id;
}
public void setOrder_id(String order_id) {
	this.order_id = order_id;
}
public List<OrderItem> getItems() {
	return items;
}
public void setItems(List<OrderItem> items) {
	this.items = items;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
 
 
}
