package com.revature.ecommerce.dto.responses;

import com.revature.ecommerce.models.User;

public class Principal {
private String id;
private String uname;
private String email;
private String password;
private String role;
public Principal() {
	
}
public Principal(String id, String uname, String email, String password, String role) {
	
	this.id = id;
	this.uname = uname;
	this.email = email;
	this.password = password;
	this.role = role;
}

public Principal (User user) {
	this.id = user.getId();
	this.uname= user.getUname();
	this.email=user.getEmail();
	this.password=user.getPassword();
	this.role = user.getRole();
}
public Principal(String id, String subject, String role) {
	this.id = id;
	this.uname = subject;
	this.role = role;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
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
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}


}
