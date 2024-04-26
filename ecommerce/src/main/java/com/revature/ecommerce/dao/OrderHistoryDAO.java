package com.revature.ecommerce.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.ecommerce.models.Order;
import com.revature.ecommerce.models.OrderHistory;
import com.revature.ecommerce.models.User;
import com.revature.ecommerce.utilities.ConnectionFactory;

public class OrderHistoryDAO {


	public List<Order> findOrderByUserID(String id) {
		List<Order> orders = new ArrayList<>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement("Select * FROM orders where user_id = ?;");
				ResultSet rs = ps.executeQuery()){
			ps.setString(1, id);
			while(rs.next()) {
				Order order = new Order();
				order.setCustomerId(id);
				order.setId(rs.getString(id));
				
				orders.add(order);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Cannot connect to database");	
		} catch (IOException e) {
			throw new RuntimeException("Cannot find application.properties file");
		}
		return orders;
	}

}
