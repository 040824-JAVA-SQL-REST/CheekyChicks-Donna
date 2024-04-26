package com.revature.ecommerce.models;

import java.util.List;

public class OrderHistory {
private String userId;
private List<String> order_id;

public OrderHistory() {
}

public OrderHistory( String userId, List<String> order_id) {
	this.userId = userId;
	this.order_id = order_id;
}



public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public List<String> getOrder_id() {
	return order_id;
}

public void setOrder_id(List<String> order_id) {
	this.order_id = order_id;
}


}
