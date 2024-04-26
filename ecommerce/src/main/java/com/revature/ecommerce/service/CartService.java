package com.revature.ecommerce.service;

import com.revature.ecommerce.dao.CartDAO;

public class CartService {
private final CartDAO cartDao;
	public CartService(CartDAO cartDAO) {
		this.cartDao = cartDAO;
	}

}
