package com.revature.ecommerce.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.ecommerce.models.Cart;
import com.revature.ecommerce.models.OrderItem;
import com.revature.ecommerce.utilities.ConnectionFactory;

public class OrderItemDAO implements CrudDAO<OrderItem> {

	@Override
	public OrderItem save(OrderItem obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement("INSERT INTO order_items (id,item_id,product_id, quantity, price) VALUES(?,?,?,?,?)")
				;){
				ps.setString(1, obj.getId());
				ps.setString(2, obj.getOrderId());
				ps.setString(3, obj.getProductId());
				ps.setInt(4, obj.getProductQuantity());
				ps.setDouble(5, obj.getPrice());
				
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
		try(Connection conn = ConnectionFactory.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement("UPDATE order_items SET  item_id = ?, product_id =?, price =?, quantity =?  WHERE id =?;");
				){
			
			
			ps.setString(1, obj.getOrderId());
			ps.setString(2, obj.getProductId());
			ps.setDouble(3, obj.getPrice());
			ps.setInt(4, obj.getProductQuantity());
			ps.setString(5,obj.getId());
				
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
	public boolean delete(String id) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement("Delete From users WHERE id =?;");) {
			ps.setString(1, id);
			int rs = ps.executeUpdate();
			if (rs > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Cannot connect to database");

		} catch (IOException e) {
			throw new RuntimeException("Cannot find application.properties file");
		}
		return false;
	}

	
	public List<OrderItem> findByOrderId(String id) {
		List<OrderItem> items = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement("Select * FROM order_items WHERE item_id =? ;");
				){
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					OrderItem item = new OrderItem();
					item.setId(rs.getString("id"));
					item.setOrderId(rs.getString("item_id"));
					item.setProductId(rs.getString("product_id"));
					item.setProductQuantity(rs.getInt("quantity"));
					item.setPrice(rs.getDouble("price"));
					items.add(item);
					
				}
			}catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Cannot connect to database");
				
				
			} catch (IOException e) {
				throw new RuntimeException("Cannot find application.properties file");
			}
		return items;
	}
	
	
	public List<OrderItem> findByProductId(String id) {
		List<OrderItem> items = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement("Select * FROM order_items WHERE product_id =? ;");
				){
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					OrderItem item = new OrderItem();
					item.setId(rs.getString("id"));
					item.setOrderId(rs.getString("item_id"));
					item.setProductId(rs.getString("product_id"));
					item.setProductQuantity(rs.getInt("quantity"));
					item.setPrice(rs.getDouble("price"));
					items.add(item);
					
				}
			}catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Cannot connect to database");
				
				
			} catch (IOException e) {
				throw new RuntimeException("Cannot find application.properties file");
			}
		return items;
	}
		

	@Override
	public OrderItem findByID(String id) {
			OrderItem item = new OrderItem();
			try(Connection conn = ConnectionFactory.getInstance().getConnection();
					PreparedStatement ps = conn.prepareStatement("Select * FROM order_items WHERE id =? ;");
					){
				ps.setString(1, id);
				ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						
						item.setId(rs.getString("id"));
						item.setOrderId(rs.getString("item_id"));
						item.setProductId(rs.getString("product_id"));
						item.setProductQuantity(rs.getInt("quantity"));
						item.setPrice(rs.getDouble("price"));
						
						
					}
				}catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException("Cannot connect to database");
					
					
				} catch (IOException e) {
					throw new RuntimeException("Cannot find application.properties file");
				}
			return item;
		}


	@Override
	public List<OrderItem> findall() {
		// TODO Auto-generated method stub
		return null;
	}

	}