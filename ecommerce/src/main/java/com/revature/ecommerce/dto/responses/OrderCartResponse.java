package com.revature.ecommerce.dto.responses;

import java.util.Date;
import java.util.List;

import com.revature.ecommerce.models.Address;
import com.revature.ecommerce.models.Cart;
import com.revature.ecommerce.models.Order;
import com.revature.ecommerce.models.OrderItem;
import com.revature.ecommerce.models.User;

public class OrderCartResponse {
private String id;
 private List<OrderItem> items;
 private double total;
 private Address address;
 private Date estimatedDeliveryDate;

public OrderCartResponse() {
	super();
	// TODO Auto-generated constructor stub
}

public OrderCartResponse(String id, String uname, String order_id, List<OrderItem> items, double total,
		Address address) {
	this.id = id;
	this.items = items;
	this.total = total;
	this.address = address;
}

public OrderCartResponse(Order order, Address add) {
	this.id = order.getId();
	this.items = order.getOrderitems();
	this.total = order.getTotal();
	this.estimatedDeliveryDate = order.getEstimatedDelivery();
	this.address = add;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
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

public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}

public Date getEstimatedDeliveryDate() {
	return estimatedDeliveryDate;
}

public void setEstimatedDeliveryDate(Date estimatedDeliveryDate) {
	this.estimatedDeliveryDate = estimatedDeliveryDate;
}


 
}
