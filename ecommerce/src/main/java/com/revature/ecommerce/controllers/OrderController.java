package com.revature.ecommerce.controllers;

import com.revature.ecommerce.service.OrderService;
import com.revature.ecommerce.service.TokenService;

import io.javalin.http.Context;

public class OrderController {
	public final OrderService ordersrv;
	public final TokenService tokensrv;
	
	public OrderController(OrderService ordersrv, TokenService tokensrv) {
		this.ordersrv = ordersrv;
		this.tokensrv = tokensrv;
	}



	public void createOrder(Context ctx) {
		 try {
			 
		 }catch(Exception e) {
			 e.printStackTrace();
			 ctx.status(500);
			 
		 }
}
	
	public void getAllOrders(Context ctx) {
		try {
			 
		 }catch(Exception e) {
			 e.printStackTrace();
			 ctx.status(500);
			 
		 }
	}
	public void getOrder(Context ctx) {
		try {
			 
		 }catch(Exception e) {
			 e.printStackTrace();
			 ctx.status(500);
			 
		 }
	}
	
	public void updateOrder(Context ctx) {
		try {
			 
		 }catch(Exception e) {
			 e.printStackTrace();
			 ctx.status(500);
			 
		 }
	}
	
	public void cancelOrder(Context ctx) {
		try {
			 
		 }catch(Exception e) {
			 e.printStackTrace();
			 ctx.status(500);
			 
		 }
	}
}
