package com.revature.ecommerce.screens;

import java.util.Scanner;

import com.revature.ecommerce.utilities.Routes;

public class StartScreen extends BaseScreen{
	
//dependency Injection 
	private final Routes router;
	private final Scanner scan;
	public StartScreen(Scanner scan, Routes router) {
		this.router = router;
		this.scan = scan;
	}
	
	
	public void start() {
		while(true) {
		clearconsole();
		System.out.println("What would you like to do?");
		System.out.println("[1] Login: ");
		System.out.println("[2]Register new user:");
		System.out.println("[3] Exit:");
		String userInput = scan.nextLine();
		 
		 switch(userInput) {
			 case "1":
				 router.navigate("/login").start();
				 break;
			 case "2":
				 router.navigate("/register").start();
				 break;
			 case "3":
				System.out.println( "Thank you for visiting, please come again!");
				 return;
			default:
				clearconsole();
				System.out.println("Invalid input! Please try again.");
				pause(scan);
				break;
			
		 }
		}
	}
}
