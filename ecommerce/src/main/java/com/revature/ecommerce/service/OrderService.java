package com.revature.ecommerce.service;

import com.revature.ecommerce.dao.OrderDAO;

public class OrderService {
	private final OrderDAO orderDao;

	public OrderService(OrderDAO orderDAO) {
		this.orderDao = orderDAO;

	}
}
