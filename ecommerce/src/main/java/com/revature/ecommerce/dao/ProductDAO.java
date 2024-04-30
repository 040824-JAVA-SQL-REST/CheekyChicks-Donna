package com.revature.ecommerce.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.ecommerce.models.Product;
import com.revature.ecommerce.models.User;
import com.revature.ecommerce.utilities.ConnectionFactory;

public class ProductDAO implements CrudDAO<Product> {

	
	@Override
	public List<Product> findall() {
		List<Product> products = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement("Select * FROM products");
				ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					Product product = new Product();
					product.setId(rs.getString("id"));
					product.setName(rs.getString("name"));
					product.setDescription(rs.getString("description"));
					product.setPrice(rs.getDouble("price"));
					product.setQuantity(rs.getInt("quantity"));
					product.setCategory(rs.getString("category"));
					products.add(product);
				}
			}catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Cannot connect to database");
				
				
			} catch (IOException e) {
				throw new RuntimeException("Cannot find application.properties file");
			}
			return products;
		}
	

	@Override
	public Product findByID(String id) {
		Product prod = new Product();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement("Select * FROM products WHERE id =? ;");
				){
				ps.setString(1, id);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					
					prod.setId(rs.getString("id"));
					prod.setName(rs.getString("name"));
					prod.setDescription(rs.getString("description"));
					prod.setPrice(rs.getDouble("price"));
					prod.setQuantity(rs.getInt("quantity"));
					prod.setCategory(rs.getString("category"));
					
				}
			}catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Cannot connect to database");
				
				
			} catch (IOException e) {
				throw new RuntimeException("Cannot find application.properties file");
			}
		return prod;
	}
	

	public Product findbyProductName(String name) {
		Product prod = new Product();
		//System.out.println("Name: " + name);
		try(Connection conn = ConnectionFactory.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement("Select * FROM products WHERE name = ?");
				){
				ps.setString(1, name);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					
					prod.setId(rs.getString("id"));
					prod.setName(rs.getString("name"));
					prod.setDescription(rs.getString("description"));
					prod.setPrice(rs.getDouble("price"));
					prod.setQuantity(rs.getInt("quantity"));
					prod.setCategory(rs.getString("category"));
					
				}
			}catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Cannot connect to database");
				
				
			} catch (IOException e) {
				throw new RuntimeException("Cannot find application.properties file");
			}
		return prod;
	}

	@Override
	public Product save(Product obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement("INSERT INTO products (id,name,description, price, quantity, category) VALUES(?,?,?,?,?,?)")
				;){
				ps.setString(1, obj.getId());
				ps.setString(2, obj.getName());
				ps.setString(3, obj.getDescription());
				ps.setDouble(4, obj.getPrice());
				ps.setLong(5, obj.getQuantity());
				ps.setString(6, obj.getCategory());
				
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
	public Product update(Product obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement("UPDATE products SET name = ?, description = ?, price = ?, quantity = ?, category = ?  WHERE id =?;");
				){
				//System.out.println( "DAO" + obj.toString());
				ps.setString(1,obj.getName());
				ps.setString(2, obj.getDescription());
				ps.setDouble(3, obj.getPrice());
				ps.setInt(4, obj.getQuantity());
				ps.setString(5,obj.getCategory());
				ps.setString(6,obj.getId());
				
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
		try(Connection conn = ConnectionFactory.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement("Delete From products WHERE id =?;");
				){
				ps.setString(1,id);
				int rs = ps.executeUpdate();
				if(rs>0) {return true;}
				
			}catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Cannot connect to database");
				
				
			} catch (IOException e) {
				throw new RuntimeException("Cannot find application.properties file");
			}
		return false;
	}


}
