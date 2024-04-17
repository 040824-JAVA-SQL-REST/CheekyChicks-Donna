package com.revature.ecommerce.models;

import java.util.List;

public class Order {
 private User customer;
 private List<Product> items;
 private String ShippingAddressId;
 private double total;
 private String status;
}
