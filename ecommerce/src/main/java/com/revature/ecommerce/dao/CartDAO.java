package com.revature.ecommerce.dao;

import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.ecommerce.models.Cart;
import com.revature.ecommerce.models.User;
import com.revature.ecommerce.utilities.ConnectionFactory;

public class CartDAO implements CrudDAO<Cart> {

	@Override
	public Cart save(Cart obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement("INSERT INTO carts (id,user_id, total_price, total_quantity, status) VALUES(?,?,?,?,?)")
				;){
				ps.setString(1, obj.getId());
				ps.setString(2, obj.getUserId());
				ps.setDouble(3, obj.getTotal());
				ps.setInt(4, obj.getQuantity());
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
	public Cart update(Cart obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement("UPDATE carts SET user_id =?,  total_price =?, product_quantity =?, status= ?  WHERE id =?;");
				){
			
			
			ps.setString(1, obj.getUserId());
			ps.setDouble(2, obj.getTotal());
			ps.setInt(3, obj.getQuantity());
			ps.setString(4, obj.getStatus());
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Cart> findall() {
		List<Cart> carts = new ArrayList<>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement("Select * FROM carts");
			ResultSet rs = ps.executeQuery()){
			while(rs.next()) {
				Cart cart = new Cart();
				cart.setId(rs.getString("id"));
				cart.setUserId(rs.getString("user_id"));
				cart.setQuantity(rs.getInt("product_quantity"));
				cart.setTotal(rs.getDouble("total_price"));
				cart.setStatus(rs.getString("status"));
				carts.add(cart);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Cannot connect to database");
			
			
		} catch (IOException e) {
			throw new RuntimeException("Cannot find application.properties file");
		}
		return carts;
	}

	@Override
	public Cart findByID(String id) {
		Cart cart = new Cart();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement("Select * FROM carts WHERE id =? ;");
				){
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					
					cart.setId(rs.getString("id"));
					cart.setUserId(rs.getString("user_id"));
					cart.setQuantity(rs.getInt("product_quantity"));
					cart.setTotal(rs.getDouble("total_price"));
					cart.setStatus(rs.getString("status"));
					
				}
			}catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Cannot connect to database");
				
				
			} catch (IOException e) {
				throw new RuntimeException("Cannot find application.properties file");
			}
		return cart;
	}

}
