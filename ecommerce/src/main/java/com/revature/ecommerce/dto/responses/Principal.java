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
	public Principal(String id, String uname, String role) {
		this.id = id;
		this.uname = uname;
		this.role = role;
	}
	public Principal(User foundUser) {
		this.uname = foundUser.getUname();
		this.role = foundUser.getRole();
		this.id = foundUser.getId();
		this.password = foundUser.getPassword();
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
