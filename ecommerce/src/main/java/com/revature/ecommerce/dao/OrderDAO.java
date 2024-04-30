package com.revature.ecommerce.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.revature.ecommerce.models.Order;
import com.revature.ecommerce.utilities.ConnectionFactory;

public class OrderDAO implements CrudDAO<Order> {

	@Override
	public Order save(Order obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement("INSERT INTO orders (id,user_id,shipping_address_id, total, status) VALUES(?,?,?,?,?)")
				;){
				ps.setString(1, obj.getId());
				ps.setString(2, obj.getCustomerId());
				ps.setString(3, obj.getShippingAddressId());
				ps.setDouble(4, obj.getTotal());
				ps.setString(5, obj.getStatus());
				
				ps.executeUpdate();
			}catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Cannot connect to database");
				
			} catch (IOException e) {
				throw new RuntimeException("Cannot find application.properties file");
			}
		return obj;
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
