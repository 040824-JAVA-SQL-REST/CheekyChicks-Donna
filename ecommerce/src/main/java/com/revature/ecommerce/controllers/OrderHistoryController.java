package com.revature.ecommerce.controllers;

import com.revature.ecommerce.service.OrderHistoryService;
import com.revature.ecommerce.service.TokenService;

import io.javalin.http.Context;

public class OrderHistoryController {
	public final OrderHistoryService ordersrv;
	public final TokenService tokensrv;
	public OrderHistoryController(OrderHistoryService orderHistoryService, TokenService tokenService) {
		this.ordersrv = orderHistoryService;
		this.tokensrv = tokenService;
	}
	
	public void createOrderHistory(Context ctx) {
		//todo
	}
	
	public void getOrderHistory(Context ctx) {
		//todo
	}
	public void updateOrderHistory(Context ctx) {
		//todo
	}
}
