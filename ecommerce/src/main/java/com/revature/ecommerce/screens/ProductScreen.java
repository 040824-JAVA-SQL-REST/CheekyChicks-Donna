package com.revature.ecommerce.screens;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.ecommerce.models.Product;
import com.revature.ecommerce.models.User;
import com.revature.ecommerce.service.ProductService;
import com.revature.ecommerce.utilities.Routes;

public class ProductScreen extends BaseScreen {
private final Scanner scan;
private final Routes router;
private User session;
private ProductService productSrv;
private List<Product> cartList = new ArrayList<>();
	public ProductScreen(Scanner scan, Routes router, User session,ProductService productSrv ) {
		this.scan = scan;
		this.router=router;
		this.session=session;
		this.productSrv = productSrv;
	}

	@Override
	public void start() {
		clearconsole();
		printScreenHeader("Product Screen");
		printSpacer();
		System.out.println("Welcome Back " + session.getUname() + "!");
		
	
		System.out.println("Please choose a product to add to your cart... ");
		pause(scan);
		while (true) {
	//	List<Product> prodList =productSrv.printProducts();
		
		int userInput = scan.nextInt();
		 
		 
		// cartList.add(prodList.get(userInput - 1));
		System.out.println(cartList);
		
	
		System.out.print("[1] Add another item?");
		System.out.print("\n [2] Check Out?" );
		System.out.print("\n [3] Log out? ");
		int input= scan.nextInt();
		
		switch (input) {
		case 1 : 
			clearconsole();
			continue;
		case 2:
			
			router.navigate("/order").start();
			break;
		case 3:
			session = new User();
			router.navigate("/start").start();
			break;
		default:
			System.out.println(" Invalud input! Please try again");
			break;
		}
		}	
		 }
	}


