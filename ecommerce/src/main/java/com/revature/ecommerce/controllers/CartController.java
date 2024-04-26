package com.revature.ecommerce.controllers;

import com.revature.ecommerce.service.CartService;
import com.revature.ecommerce.service.TokenService;

import io.javalin.http.Context;

public class CartController {
	private final CartService cartsrv;
	private final TokenService tokenService;

	public CartController(CartService cartsrv, TokenService tokenService) {
		this.cartsrv = cartsrv;
		this.tokenService = tokenService;
	}

	public void createCart(Context ctx) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
			ctx.status(500);

		}
	}
	public void getCart(Context ctx) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
			ctx.status(500);

		}
		
	}
	
	public void updateCart(Context ctx) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
			ctx.status(500);

		}
	}
	public void checkout(Context ctx) {
	try {

	} catch (Exception e) {
		e.printStackTrace();
		ctx.status(500);

	}
}
}

