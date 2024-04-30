package com.revature.ecommerce.models;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Order {
private String id;
 private String customerId;
 private List<OrderItem> orderitems;
 private String ShippingAddressId;
 private double total;
 private String status;
 private Date estimatedDelivery;
 
public Order() {
}


public Order(String id, String customerId, List<OrderItem> orderitems, String shippingAddressId, double total,
		String status, Date estimatedDelivery) {
	super();
	this.id = id;
	this.customerId = customerId;
	this.orderitems = orderitems;
	ShippingAddressId = shippingAddressId;
	this.total = total;
	this.status = status;
	this.estimatedDelivery = estimatedDelivery;
}


public Order(Cart cart) {
  this.id = cart.getItemsId();
  this.customerId = cart.getUserId();
  this.total = cart.getTotal();
  this.status = "Paid";
  
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getCustomerId() {
	return customerId;
}

public void setCustomerId(String customerId) {
	this.customerId = customerId;
}

public List<OrderItem> getOrderitems() {
	return orderitems;
}

public void setOrderitems(List<OrderItem> orderitems) {
	this.orderitems = orderitems;
}

public String getShippingAddressId() {
	return ShippingAddressId;
}

public void setShippingAddressId(String shippingAddressId) {
	ShippingAddressId = shippingAddressId;
}

public double getTotal() {
	return total;
}

public void setTotal(double total) {
	this.total = total;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}


public Date getEstimatedDelivery() {
	return estimatedDelivery;
}


public void setEstimatedDelivery(Date estimatedDelivery) {
	this.estimatedDelivery = estimatedDelivery;
}
 
}
