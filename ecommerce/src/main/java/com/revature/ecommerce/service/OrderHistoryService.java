package com.revature.ecommerce.service;

import com.revature.ecommerce.dao.OrderDAO;

public class OrderHistoryService {
private final OrderDAO orderDao ;

	public OrderHistoryService(OrderDAO orderDAO) {
		this.orderDao = orderDAO;
	}

}
