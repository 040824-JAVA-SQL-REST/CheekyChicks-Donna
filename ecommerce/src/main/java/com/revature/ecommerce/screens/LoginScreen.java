package com.revature.ecommerce.screens;

import java.util.Optional;
import java.util.Scanner;

import com.revature.ecommerce.models.User;
import com.revature.ecommerce.service.UserService;
import com.revature.ecommerce.utilities.Routes;

public class LoginScreen extends BaseScreen {
private final Scanner scan;
private final Routes router;
private final UserService userService;
private User session;
	public LoginScreen(Scanner scan, Routes router, UserService userService, User session) {
		this.scan = scan;
		this.router = router;
		this.userService = userService;
		this.session = session;
	}

	@Override
	public void start() {
		clearconsole();
		printScreenHeader("Login Screen");
		while(true) {
			System.out.println(" Please login..");
			System.out.println("Enter Username: ");
			String username= scan.nextLine();
			System.out.println("Please enter password: ");
			String password = scan.nextLine();
			
			Optional<User> optUser = userService.login(username, password);
			if(optUser.isEmpty()) {
				clearconsole();
				System.out.println("Invalid user name or password.");
				
				pause(scan);
				continue;
			}
			User loggedInUser = optUser.get();
			session.setId(loggedInUser.getId())
				.setUname(loggedInUser.getUname())
				.setEmail(loggedInUser.getEmail())
				.setPassword(loggedInUser.getPassword())
				.setRole(loggedInUser.getRole());
			
			if(session.getRole().equals("ADMIN")) {
				router.navigate("/admin").start();
			}
			else { router.navigate("/product").start();}
			break;
		}
		
		
		
	}

}
