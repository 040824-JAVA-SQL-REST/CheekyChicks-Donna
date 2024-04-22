package com.revature.ecommerce.screens;

import java.util.Scanner;

public abstract class BaseScreen {

	public abstract void start();
	
	protected void clearconsole() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
		}
	
	protected void pause(Scanner scan) {
		System.out.println("Press enter to continue..");
		scan.nextLine();
	}
	
	protected void printScreenHeader(String header) {
		System.out.println("************************************************");
		System.out.println("************************************************");
		System.out.println("**                                            **");
		System.out.println("  		    " + header +"                   ");
		System.out.println("**                                            **");
		System.out.println("************************************************");
		System.out.println("************************************************");
	}
	
	protected void printSpacer() {
		System.out.println();
		System.out.println();
		
	}
	protected void printFormatter() {
		System.out.print("                        ");
		}
}
