package com.revature.ecommerce.dto.requests;

public class CartRequest {
  private String uId;
  private double price;
  private int quantity;
  private String status;
  
  
public CartRequest() { }

public CartRequest(String uid) { 
	this.uId = uid;
}

public CartRequest(String uId, double price, int quantity, String status) {
	super();
	this.uId = uId;
	this.price = price;
	this.quantity = quantity;
	this.status = status;
}


public String getuId() {
	return uId;
}


public void setuId(String uId) {
	this.uId = uId;
}


public double getPrice() {
	return price;
}


public void setPrice(double price) {
	this.price = price;
}


public int getQuantity() {
	return quantity;
}


public void setQuantity(int quantity) {
	this.quantity = quantity;
}


public String getStatus() {
	return status;
}


public void setStatus(String status) {
	this.status = status;
}


}
  
  
