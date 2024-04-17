package com.revature.ecommerce.screens;

import java.util.Scanner;

import com.revature.ecommerce.models.User;
import com.revature.ecommerce.service.UserService;
import com.revature.ecommerce.utilities.Routes;

public class RegisterScreen extends BaseScreen {
	private UserService userSvc;
	private Routes router;
	private String userName;
	private String email;
	private String password;
	private Scanner scan;

	public RegisterScreen(UserService userSvc, Scanner scan, Routes router) {
		this.userSvc = userSvc;
		this.scan = scan;
		this.router = router;
	}

	public RegisterScreen() {

	}

	@Override
	public void start() {
		//loop until the whole process is correct
		while (true) {
			clearconsole();
			System.out.println("create new user...");

			System.out.println("");
			// loop until user name is correct
		 while(true) {
			System.out.println("Input UserName:");
			userName =scan.nextLine();
			if (userSvc.userNameExists(userName)) {
				clearconsole();
				System.out.println("User Name already exists");
				System.out.println("please try again.");
				pause(scan);
				continue;
			}
			if (!userSvc.validateUsername(userName)) {
				clearconsole();
				System.out.println("Invalid user name: User name can only contain numbers and letters.");
				System.out.println("please try again.");
				pause(scan);
				continue;
			}
			break; 
		}
			//loop until email is correct
		 while(true) {
			System.out.println("Input Email:");
			 email = scan.nextLine();
			if (userSvc.validateEmail(email)) {
				clearconsole();
				System.out.println("Invalid email...");
				System.out.println("please try again.");
				pause(scan);
				continue;
			}
			
			break;
		 }
		 //loop until password is correct
		 while(true) {
			System.out.println("Input Password: ");
			password = scan.nextLine();
			System.out.println("Confirm Password: ");
			String confirmation = scan.nextLine();
			if (!password.equals(confirmation)) {
				clearconsole();
				System.out.println("Password and Confirm password do not match");
				System.out.println("please try again.");
				pause(scan);
				continue;
			}
			if (!userSvc.ValidatePassword(password, confirmation)) {
				clearconsole();
				System.out.println("Password must be at least 8 characters...");
				System.out.println("Contain at least one uppercase and lowercase letter..");
				System.out.println("Contain at least one special character and one number! ");
				System.out.println("please try again.");
				pause(scan);
				continue;
			}
			break;
		 }
		 //save logic
		 User newUser= new User(userName, password, email);
		 userSvc.saveUser(newUser);
		 clearconsole();
		 System.out.println("Account Successfully Created!");
		 pause(scan);
			break;
		}
	}

}
