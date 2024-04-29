package com.revature.ecommerce.controllers;

import java.util.HashMap;
import java.util.Map;

import com.revature.ecommerce.dto.requests.CartRequest;
import com.revature.ecommerce.dto.requests.ProductRequest;
import com.revature.ecommerce.dto.responses.Principal;
import com.revature.ecommerce.models.Cart;
import com.revature.ecommerce.models.Product;
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
			Map<String, String> errs = new HashMap<>();
			// get token
			String token = ctx.header("auth-token");
			// validate token
			if (token.isEmpty() || token == null) {
				errs.put("Error:", "Unauthorized : please login");
				ctx.status(401);// unauthorized
				ctx.json(errs);
				return;
			}
	
			// parse the token to get principal
			Principal principal = tokenService.parseToken(token);
			// validate principal
			if (principal == null) {
				errs.put("Error:", "Unauthorized : please login");
				ctx.status(401);// unauthorized- not logged in.
				ctx.json(errs);
				return;
			}
			//System.out.println(principal.getId());
			//can only have one cart per user
			if(cartsrv.ifCartIsNotUnique(principal.getId())) {
				errs.put("Error:", "Duplicate: Cart already exists.");
				ctx.status(400);
				ctx.json(errs);
				return;
			}
						
			//System.out.print("cart controller.. create new cart");
			Cart newCart = cartsrv.initializeCart(principal.getId());
			ctx.json(newCart);
			ctx.status(201);
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
	
	public void addItemToCart(Context ctx) {
		try {
			Map<String, String> errs = new HashMap<>();
			// get token
			String token = ctx.header("auth-token");
			// validate token
			if (token.isEmpty() || token == null) {
				errs.put("Error:", "Unauthorized : please login");
				ctx.status(401);// unauthorized
				ctx.json(errs);
				return;
			}

			// parse the token to get principal
			Principal principal = tokenService.parseToken(token);
			// validate principal
			if (principal == null) {
				errs.put("Error:", "Unauthorized : please login");
				ctx.status(401);// unauthorized- not logged in.
				ctx.json(errs);
				return;
			}
			Product prod = ctx.bodyAsClass(Product.class);
			
			Cart cart =cartsrv.addItem(prod.getId(),principal.getId());
			ctx.json(cart);
			ctx.status(201);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.status(500);

		}
	}
	
	public void removeItemFromCart(Context ctx) {
		try {
			Map<String, String> errs = new HashMap<>();
			// get token
			String token = ctx.header("auth-token");
			// validate token
			if (token.isEmpty() || token == null) {
				errs.put("Error:", "Unauthorized : please login");
				ctx.status(401);// unauthorized
				ctx.json(errs);
				return;
			}

			// parse the token to get principal
			Principal principal = tokenService.parseToken(token);
			// validate principal
			if (principal == null) {
				errs.put("Error:", "Unauthorized : please login");
				ctx.status(401);// unauthorized- not logged in.
				ctx.json(errs);
				return;
			}
			String id = ctx.pathParam("id");
			
			Cart cart = cartsrv.removeItem(id, principal.getId());
			ctx.json(cart);
			ctx.status(205);

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

