package com.revature.ecommerce.models;

import java.util.List;
import java.util.UUID;

public class Cart {
private String id;
private String userId;
private List<Product> items;
private double total;
private int quantity;

public Cart () {}
public Cart( String userId, List<Product> items, double total, int quantity) {
	
	this.id = UUID.randomUUID().toString();
	this.userId = userId;
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
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public List<Product> getItems() {
	return items;
}
public void setItems(List<Product> items) {
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
