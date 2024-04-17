package com.revature.ecommerce.utilities;

import java.util.Scanner;

import com.revature.ecommerce.screens.BaseScreen;
import com.revature.ecommerce.screens.LoginScreen;
import com.revature.ecommerce.screens.OrderHistoryScreen;
import com.revature.ecommerce.screens.OrderScreen;
import com.revature.ecommerce.screens.ProductScreen;
import com.revature.ecommerce.screens.RegisterScreen;
import com.revature.ecommerce.screens.StartScreen;
import com.revature.ecommerce.service.UserService;

public class Routes {
 private final Scanner scan;
 private final UserService userService;
 
	public Routes(UserService userService, Scanner scan) {
		this.userService = userService;
		this.scan = scan;
}

	public BaseScreen navigate(String path) {
		switch (path) {
		case "/start": 
			return new StartScreen(scan, this);
		case "/login": 
			return new LoginScreen();
		case "/register": 
			return new RegisterScreen(userService, scan, this);
		case "/history":
			return new OrderHistoryScreen(scan, this);
		case"/order":
			return new OrderScreen(scan,this);
		case"/product":
			return new ProductScreen(scan,this);
		default:
			
			throw new IllegalArgumentException("Invalid path " + path);
		}
	}
}
