package com.revature.ecommerce.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ecommerce.dto.requests.ProductRequest;
import com.revature.ecommerce.dto.responses.Principal;
import com.revature.ecommerce.models.Product;
import com.revature.ecommerce.models.User;
import com.revature.ecommerce.service.ProductService;
import com.revature.ecommerce.service.TokenService;

import io.javalin.http.Context;

public class ProductController {
	private final ProductService productsrv;
	private final TokenService tokensrv;

	public ProductController(ProductService productsrv, TokenService tokensrv) {
		this.productsrv = productsrv;
		this.tokensrv = tokensrv;
	}

	// admin function
	public void addProduct(Context ctx) {
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
			Principal principal = tokensrv.parseToken(token);
			// validate principal
			if (principal == null) {
				errs.put("Error:", "Unauthorized : please login");
				ctx.status(401);// unauthorized- not logged in.
				ctx.json(errs);
				return;
			}
			if (!principal.getRole().equalsIgnoreCase("admin")) {
				errs.put("Error:", "You do not have access to perform this action");
				ctx.status(403);// forbidden - incorrect permissions.
				ctx.json(errs);
				return;
			}

			ProductRequest request = ctx.bodyAsClass(ProductRequest.class);

			// validate request
			if (request.getName().isEmpty() || !productsrv.isUniqueProductName(request.getName())) {
				errs.put("Error:", "Invalid Product name");
				ctx.status(400);
				ctx.json(errs);
				return;
			}
			Product product = new Product(request);
			productsrv.saveProduct(product);
			ctx.status(201);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.status(500);

		}
	}

//login not needed to view products
	public List<Product> getAllProducts(Context ctx) {
		List<Product> prods = productsrv.getAllProducts();
		try {


			ObjectMapper objectMapper = new ObjectMapper();
			try {
				String jsonArray = objectMapper.writeValueAsString(prods);
				ctx.json(jsonArray);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				ctx.status(500);
			}
			ctx.status(200);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.status(500);

		}
		return prods;
	}

//default function
	public void getProduct(Context ctx) {
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
			Principal principal = tokensrv.parseToken(token);
			// validate principal logged in
			if (principal == null) {
				errs.put("Error:", "Unauthorized : please login");
				ctx.status(401);// unauthorized- not logged in.
				ctx.json(errs);
				return;
			}
			String id = ctx.pathParam("id");
			if (id == null) {
				errs.put("Error:", "ID " + id + " Not found");
				ctx.status(404); // not found
				ctx.json(errs);
			}
			Product prod = productsrv.getProductById(id);
			ctx.json(prod);
			ctx.status(200);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.status(500);

		}
	}

// admin function
	public void updateProduct(Context ctx) {
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
			Principal principal = tokensrv.parseToken(token);
			// validate principal
			if (principal == null) {
				errs.put("Error:", "Unauthorized : please login");
				ctx.status(401);// unauthorized- not logged in.
				ctx.json(errs);
				return;
			}
			if (!principal.getRole().equalsIgnoreCase("admin")) {
				errs.put("Error:", "You do not have access to perform this action");
				ctx.status(403);// forbidden - incorrect permissions.
				ctx.json(errs);
				return;
			}

			ProductRequest request = ctx.bodyAsClass(ProductRequest.class);

			// validate request
			if (request.getName().isEmpty() || request.getDescription().isEmpty() || request.getCategory().isEmpty()) {
				errs.put("Error:", "Please enter product information");
				ctx.status(400);
				ctx.json(errs);
				return;
			}

			Product product = new Product(request);

			productsrv.updateProduct(product);
			ctx.status(200);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.status(500);

		}
	}

//admin function
	public void removeProduct(Context ctx) {
		try {
			// todo
			String token = ctx.header("auth-token");
		} catch (Exception e) {
			e.printStackTrace();
			ctx.status(500);

		}
	}
}
