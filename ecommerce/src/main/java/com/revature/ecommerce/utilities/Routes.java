package com.revature.ecommerce.utilities;

import java.util.Scanner;

import com.revature.ecommerce.models.User;
import com.revature.ecommerce.screens.AdminScreen;
import com.revature.ecommerce.screens.BaseScreen;
import com.revature.ecommerce.screens.LoginScreen;
import com.revature.ecommerce.screens.OrderHistoryScreen;
import com.revature.ecommerce.screens.OrderScreen;
import com.revature.ecommerce.screens.ProductScreen;
import com.revature.ecommerce.screens.RegisterScreen;
import com.revature.ecommerce.screens.StartScreen;
import com.revature.ecommerce.service.ProductService;
import com.revature.ecommerce.service.UserService;

public class Routes {
 private final Scanner scan;
 private final UserService userService;
 private final ProductService productSrv;
 private User session;
 
 
	public Routes(UserService userService, Scanner scan, User session,ProductService productService) {
		this.userService = userService;
		this.scan = scan;
		this.session = session;
		this.productSrv = productService;
		
}

	public BaseScreen navigate(String path) {
		switch (path) {
		case "/start": 
			return new StartScreen(scan, this);
		case "/login": 
			return new LoginScreen(scan, this, userService, session);
		case "/register": 
			return new RegisterScreen(userService, scan, this);
		case "/history":
			return new OrderHistoryScreen(scan, this);
		case"/order":
			return new OrderScreen(scan,this);
		case"/product":
			return new ProductScreen(scan, this, session, productSrv);
		case"/admin":
			return new AdminScreen(userService, productSrv,session, scan, this);
		default:
			
			throw new IllegalArgumentException("Invalid path " + path);
		}
	}
}
