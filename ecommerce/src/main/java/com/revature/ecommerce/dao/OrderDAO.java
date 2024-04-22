package com.revature.ecommerce.dao;

import java.util.List;

import com.revature.ecommerce.models.Order;

public class OrderDAO implements CrudDAO<Order> {

	@Override
	public Order save(Order obj) {
		return obj;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> findall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findByID(String id) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Order update(Order obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
