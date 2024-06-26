package com.revature.ecommerce.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ecommerce.dto.requests.LoginRequest;
import com.revature.ecommerce.dto.requests.ProductRequest;
import com.revature.ecommerce.dto.requests.RegisterRequest;
import com.revature.ecommerce.dto.requests.UserRequest;
import com.revature.ecommerce.dto.responses.Principal;
import com.revature.ecommerce.models.Product;
import com.revature.ecommerce.models.User;
import com.revature.ecommerce.service.TokenService;
import com.revature.ecommerce.service.UserService;

import io.javalin.http.Context;

public class UserController {
private final UserService userService;
private final TokenService tokenService;
	
public UserController(UserService userService, TokenService tokenService) {
	
	this.userService = userService;
	this.tokenService = tokenService;
}

	public void register(Context ctx) {
		try{
			Map<String, String> err = new HashMap<>();
			
			RegisterRequest request = ctx.bodyAsClass(RegisterRequest.class);
			if(!userService.validateUsername(request.getUname())){
				ctx.status(400); //bad user request
				err.put("Error:" , "Invalid User Name.");
				ctx.json(err);
				return;
			}
			if(userService.userNameExists(request.getUname())) {
				ctx.status(409); //conflict
				err.put("Error:" , "User name must be unique.");
				ctx.json(err);
				return;
			}
			
			if (!userService.validateEmail(request.getEmail())) {
				ctx.status(400);
				err.put("Error:" , "Invalid email.");
				ctx.json(err);
				return; 
			}
			if(userService.emailExists(request.getEmail())) {
				ctx.status(409);
				err.put("Error: ", "Email must be unique.");
				ctx.json(err);
				return;
			}
			if (!userService.ValidatePassword(request.getPassword())) {
				ctx.status(400);//bad request
				err.put("Error:" , "Invalid password");
				ctx.json(err);
				return;
			}
			User user = new User(request);
			 userService.saveUser(user);
			ctx.status(201);//created
		}catch(Exception e) {
			ctx.status(500);
			e.printStackTrace();
		}
	}
	
	public void login(Context ctx) {
		try {
			Map<String, String> err = new HashMap<>();
			LoginRequest request = ctx.bodyAsClass(LoginRequest.class);
			Optional<User> optUser = userService.login(request.getUname(), request.getPassword());
			if (optUser.isEmpty()) {
				err.put("Error:" , "Invalid User Name or Password");
				ctx.json(err);
				ctx.status(400);
				return;
			}
			User foundUser = optUser.get();
			Principal principal = new Principal(foundUser);
			String token = tokenService.generateToken(principal);
			//set token to the header
			ctx.header("auth-token", token);
			
			ctx.json(principal);
			ctx.status(200);
		}catch(Exception e) {
			ctx.status(500);
			e.printStackTrace();
		}
		
	}
	
	public void updateUser(Context ctx) {
		try {
			Map<String,String> errs= new HashMap<>();
			//get token
			String token = ctx.header("auth-token");
			//validate token
			if(token.isEmpty()|| token==null) {
				errs.put("Error:", "Unauthorized : please login");
				ctx.status(401);//unauthorized
				ctx.json(errs);
				return;
			}
			
			//parse the token to get principal
			Principal principal = tokenService.parseToken(token);
			//validate principal
			if(principal ==null) {
				errs.put("Error:", "Unauthorized : please login");
				ctx.status(401);//unauthorized- not logged in.
				ctx.json(errs);
				return;
			}
			if(!principal.getRole().equalsIgnoreCase("admin") ) {
				errs.put("Error:", "You do not have access to perform this action");
				ctx.status(403);//forbidden - incorrect permissions.
				ctx.json(errs);
				return;
			}
			
			UserRequest request = ctx.bodyAsClass(UserRequest.class);
			User user = new User(request);
			userService.updateUser(user);
			ctx.status(200);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.status(500);

		}
	}
	
	public void getAllUsers(Context ctx) {
		try {
			Map<String,String> errs= new HashMap<>();
			//get token
			String token = ctx.header("auth-token");
			//validate token
			if(token.isEmpty()|| token==null) {
				errs.put("Error:", "Unauthorized : please login");
				ctx.status(401);//unauthorized
				ctx.json(errs);
				return;
			}
			
			//parse the token to get principal
			Principal principal = tokenService.parseToken(token);
			//validate principal
			if(principal ==null) {
				errs.put("Error:", "Unauthorized : please login");
				ctx.status(401);//unauthorized- not logged in.
				ctx.json(errs);
				return;
			}
			if(!principal.getRole().equalsIgnoreCase("admin") ) {
				errs.put("Error:", "You do not have access to perform this action");
				ctx.status(403);//forbidden - incorrect permissions.
				ctx.json(errs);
				return;
			}
			
			List<User> users= userService.getAllUsers();
			ObjectMapper objectMapper = new ObjectMapper(); 
	        try { 
	            String jsonArray 
	                = objectMapper.writeValueAsString(users); 
	           ctx.json(jsonArray);
	        } 
	        catch (JsonProcessingException e) { 
	            e.printStackTrace();
	            ctx.status(500);
	        } 
			ctx.status(200);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.status(500);

		}

}
}
