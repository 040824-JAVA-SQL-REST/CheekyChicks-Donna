package com.revature.ecommerce.models;

import java.util.List;
import java.util.UUID;

import com.revature.ecommerce.dto.requests.RegisterRequest;
import com.revature.ecommerce.dto.requests.UserRequest;

public class User {
private String id;
private String uname;
private String email;
private String password;
// Roles : DEFAULT = customer level, ADMIN = management/employee level
private String role;
public User() {
	
}
public User(String uname, String email, String password) {
	//creates random ID
	this.id = UUID.randomUUID().toString();
	this.uname = uname;
	this.email = email;
	this.password = password;
	this.role = "DEFAULT";
}
//overloaded constructor 
public User(String[] data) {
	this.id = data[0];
	this.uname = data[1];
	this.email = data[2];
	this.password = data[3];
	this.role = data[4];
					 
}
//constructor for DTO
public User(RegisterRequest request) {
	this.id = UUID.randomUUID().toString();
	this.uname = request.getUname();
	this.email = request.getEmail();
	this.password = request.getPassword();
	this.role = "DEFAULT";
}
public User(UserRequest request) {
	this.id = request.getId();
	this.uname = request.getUname();
	this.email = request.getEmail();
	this.password = request.getPassword();
	this.role = request.getRole();
}
//accessors and mutators (getters and setters)
public String getUname() {
	return uname;
}
public User setUname(String uname) {
	this.uname = uname;
	return this;
}
public String getEmail() {
	return email;
}
public User setEmail(String email) {
	this.email = email;
	return this;
}
public String getPassword() {
	return password;
}
public User setPassword(String password) {
	this.password = password;
	return this;
}

public String getId() {
	return id;
}
public User setId(String id) {
	this.id = id;
	return this;
}
public String getRole() {
	return role;
}
public User setRole(String role) {
	this.role = role;
	return this;
}




}
