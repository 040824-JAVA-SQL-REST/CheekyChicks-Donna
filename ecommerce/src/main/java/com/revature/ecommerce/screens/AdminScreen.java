package com.revature.ecommerce.screens;

import java.util.Scanner;

import com.revature.ecommerce.models.Product;
import com.revature.ecommerce.models.User;
import com.revature.ecommerce.service.ProductService;
import com.revature.ecommerce.service.UserService;
import com.revature.ecommerce.utilities.Routes;

public class AdminScreen extends BaseScreen {
private final UserService userSrv;
private final ProductService productSrv;
private final User session;
private final Scanner scan;
private final Routes router;

	
	
	
	public AdminScreen(UserService userSrv, ProductService productSrv, User session, Scanner scan, Routes router) {
	super();
	this.userSrv = userSrv;
	this.productSrv = productSrv;
	this.session = session;
	this.scan = scan;
	this.router = router;
}




	@Override
	public void start() {
		clearconsole();
		printScreenHeader("Admin Screen");
		System.out.println("Welcome " + session.getUname()+ "!");
		System.out.println();
		System.out.println("What would you like to do ? ");
		System.out.println("[1] Manage products");
		System.out.println("[2] Manage orders");
		System.out.println("[3] Manage Users");
		System.out.println("[4] View product screen");
		String userInput = scan.nextLine();
		 
		 switch(userInput) {
			 case "1":
				  clearconsole();
				  manageProducts();
				 break;
			 case "2":
				 clearconsole();
				 manageOrders();
				 break;
			 case "3":
				clearconsole();
				manageUsers();
			 case"4":
				 clearconsole();
				 router.navigate("/product").start();
				 return;
			default:
				clearconsole();
				System.out.println("Invalid input! Please try again.");
				pause(scan);
				break;
			
		 }
		
	}
	
	//sub menus
	private void manageUsers() {
		// TODO Auto-generated method stub
		
	}




	private void manageOrders() {
		// TODO Auto-generated method stub
		
	}




	private void manageProducts() {
		System.out.println("[1] Add prodcut");
		System.out.println("[2] Update product");
		System.out.println("[3] Discontinue product");
		System.out.println("[4] Back");
		String userInput = scan.nextLine();
		 
		 switch(userInput) {
			 case "1":
				  clearconsole();
				  Product prod= newProduct();
				  productSrv.saveProduct(prod);
				 break;
			 case "2":
				 clearconsole();
				 break;
			 case "3":
				 clearconsole();
				 break;
			 case "4":
				 router.navigate("/admin").start();
				 break;
			default:
				clearconsole();
				System.out.println("Invalid input! Please try again.");
				pause(scan);
				break;
			
		 }
	

}




	private Product newProduct() {
		Product prod = new Product();
		System.out.println("Please enter product name: ");
		prod.setName(scan.nextLine());
		System.out.println("Please enter product price: ");
		prod.setPrice(scan.nextDouble());
		System.out.println("Please enter the product quantity: ");
		prod.setQuantity(scan.nextInt());
		System.out.println("Please enter the product description: ");
		prod.setDescription(scan.nextLine());
		System.out.println("Pleas enter the product category: ");
		prod.setCategory(scan.nextLine());
		System.out.println(prod);
		return prod;
		
	}
}
