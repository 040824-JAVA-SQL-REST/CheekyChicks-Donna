package com.revature.ecommerce.models;

import java.util.List;
import java.util.UUID;

public class User {
private String id;
private String uname;
private String email;
private String password;
//private Address address;
private String role;
private List<Order> orders;

public User() {
	
}
public User(String uname, String email, String password) {
	//creates random ID
	this.id = UUID.randomUUID().toString();
	this.uname = uname;
	this.email = email;
	this.password = password;
	this.role = "default";
}
//overloaded constructor 
public User(String[] data) {
	this.id = data[0];
	this.uname = data[1];
	this.email = data[2];
	this.password = data[3];
	//this.address.setId(data[4]);
	this.role = data[4];
					 
}

//accessors and mutators (getters and setters)
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
//public Address getAddress() {
//	return address;
//}
//public void setAddress(Address address) {
//	this.address = address;
//}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}

public String convertToData() {
	return this.id + "/" + this.uname + "/" + this.email + "/" + this.password  + "/" + this.role;
}


}
