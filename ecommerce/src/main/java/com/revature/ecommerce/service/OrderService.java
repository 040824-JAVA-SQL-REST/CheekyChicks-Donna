package com.revature.ecommerce.service;

import com.revature.ecommerce.dao.OrderDAO;
import com.revature.ecommerce.models.Order;

public class OrderService {
	private final OrderDAO orderDao;

	public OrderService(OrderDAO orderDAO) {
		this.orderDao = orderDAO;

	}

	public void persistOrder(Order order) {
		orderDao.save(order);
		
	}
}
