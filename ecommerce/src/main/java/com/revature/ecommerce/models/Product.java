package com.revature.ecommerce.models;

import java.util.UUID;

public class Product {
 private String id;
 private String name;
 private String description;
 private double price;
 private int quantity;
 private String category;
 
public Product() {this.id = UUID.randomUUID().toString();}
public Product( String name, String description, double price, int quantity, String category) {
	
	this.id = UUID.randomUUID().toString();
	this.name = name;
	this.description = description;
	this.price = price;
	this.quantity = quantity;
	this.category = category;
}



public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
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


public String printProduct() {
	return "| Product Name: " + name  + "  |  Price: " + price + "  |  Quantity: "
			+ quantity + "  |   Description:  " + description + " |";
}
@Override
public String toString() {
	return "Product [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
}


 
}
