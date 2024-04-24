package com.revature.ecommerce.utilities;

import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

import java.io.IOException;

import com.revature.ecommerce.controllers.UserController;
import com.revature.ecommerce.dao.UserDAO;
import com.revature.ecommerce.service.TokenService;
import com.revature.ecommerce.service.UserService;

import io.javalin.Javalin;

public class JavalinUtils {
	
	
	public Javalin getJavalin() throws IOException {
		 UserController userController = new UserController(new UserService(new UserDAO()), new TokenService());
		return Javalin.create(config -> {
	    	 config.router.apiBuilder(()->{
	    		 path("/users", ()-> {
	    			 post("/register",userController:: register );
	    			 post("/login", userController:: login);
	    		 });
	    	 });
	    	 });         
	    }
	}

