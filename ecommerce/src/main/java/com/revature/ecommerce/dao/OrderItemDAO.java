package com.revature.ecommerce.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.revature.ecommerce.models.OrderItem;
import com.revature.ecommerce.utilities.ConnectionFactory;

public class OrderItemDAO implements CrudDAO<OrderItem> {

	@Override
	public OrderItem save(OrderItem obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement("INSERT INTO order_items (id,order_id,product_id, product_quantity, product_total) VALUES(?,?,?,?,?)")
				;){
				ps.setString(1, obj.getId());
				ps.setString(2, obj.getOrderId());
				ps.setString(3, obj.getProductId());
				ps.setInt(4, obj.getProductQuantity());
				ps.setDouble(5, obj.getProductTotal());
				
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
	public OrderItem update(OrderItem obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<OrderItem> findall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderItem findByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
