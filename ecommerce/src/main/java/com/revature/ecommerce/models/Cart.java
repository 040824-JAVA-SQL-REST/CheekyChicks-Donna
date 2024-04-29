package com.revature.ecommerce.models;

import java.util.List;
import java.util.UUID;

import com.revature.ecommerce.dto.requests.CartRequest;

public class Cart {
private String id;
private String userId;
private String itemsId;
private double total;
private int quantity;
private String status;

public Cart () {
	this.id = UUID.randomUUID().toString();
	this.itemsId= UUID.randomUUID().toString();
}

public Cart( String userId, String itemsId, double total, int quantity, String status) {
	
	this.id = UUID.randomUUID().toString();
	this.userId = userId;
	this.itemsId = itemsId;
	this.total = total;
	this.quantity = quantity;
	this.status = status;
}


public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
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
public String getItemsId() {
	return itemsId;
}
public void setItemsId(String itemsId) {
	this.itemsId = itemsId;
}

@Override
public String toString() {
	return "Cart [id=" + id + ", userId=" + userId + ", itemsId=" + itemsId + ", total=" + total + ", quantity="
			+ quantity + ", status=" + status + "]";
}

}
