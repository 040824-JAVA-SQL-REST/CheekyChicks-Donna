package com.revature.ecommerce.dto.responses;

import java.util.ArrayList;
import java.util.List;

import com.revature.ecommerce.models.Product;

public class Catalog {

 private String name;
 private int inventory;
 private String description;
 private double price;
public Catalog() {
	super();
	// TODO Auto-generated constructor stub
}
public Catalog(String name, int inventory, String description, double price) {
	super();
	this.name = name;
	this.inventory = inventory;
	this.description = description;
	this.price = price;
}
public List<Catalog> getCatalog(List<Product> prod){
 List<Catalog> cat = new ArrayList<>() ;
	for(Product p : prod) {
		if (p.getQuantity()> 0) {
		Catalog catItem = new Catalog();
		catItem.setName(p.getName());
		catItem.setDescription(p.getDescription());
		catItem.setPrice(p.getPrice());
		catItem.setInventory(p.getQuantity());
			cat.add(catItem);
		}
	}
	return cat;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getInventory() {
	return inventory;
}
public void setInventory(int inventory) {
	this.inventory = inventory;
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
 
}
