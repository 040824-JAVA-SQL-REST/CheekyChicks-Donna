package com.revature.ecommerce.models;

import java.util.UUID;

public class Address {
private String id;
private String street;
private String street2;
private String  city;
private String state;
private String country;
private String postalcode;
public Address() {
	
}
public Address( String street, String street2, String city, String state, String country, String postalcode) {
	super();
	this.id = UUID.randomUUID().toString();
	this.street = street;
	this.street2 = street2;
	this.city = city;
	this.state = state;
	this.country = country;
	this.postalcode = postalcode;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getStreet2() {
	return street2;
}
public void setStreet2(String street2) {
	this.street2 = street2;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getPostalcode() {
	return postalcode;
}
public void setPostalcode(String postalcode) {
	this.postalcode = postalcode;
}


}
