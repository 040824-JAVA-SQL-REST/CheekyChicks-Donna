package com.revature.ecommerce.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.ecommerce.models.User;
import com.revature.ecommerce.utilities.ConnectionFactory;

public class UserDAO implements CrudDAO<User> {
//CRUD operations Create Read Update Delete
	
	
	
	@Override
	public User save(User obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement("INSERT INTO users (id,uname,email, password, role) VALUES(?,?,?,?,?)")
				;){
				ps.setString(1, obj.getId());
				ps.setString(2, obj.getUname());
				ps.setString(3, obj.getEmail());
				ps.setString(4, obj.getPassword());
				ps.setString(5, obj.getRole());
				
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
	public List<User> findall() {
		List<User> users = new ArrayList<>();

		try(Connection conn = ConnectionFactory.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement("Select * FROM users");
			ResultSet rs = ps.executeQuery()){
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getString("id"));
				user.setUname(rs.getString("uname"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				users.add(user);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Cannot connect to database");
			
			
		} catch (IOException e) {
			throw new RuntimeException("Cannot find application.properties file");
		}
		return users;
	}

	@Override
	public User findByID(String id) {
		User user = new User();
		try(Connection conn = ConnectionFactory.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement("Select * FROM users WHERE id =? ;");
				){
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					
					user.setId(rs.getString("id"));
					user.setUname(rs.getString("uname"));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));
					user.setRole(rs.getString("role"));
					
				}
			}catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("Cannot connect to database");
				
				
			} catch (IOException e) {
				throw new RuntimeException("Cannot find application.properties file");
			}
		return user;
			
	}




	@Override
	public User update(User obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement("UPDATE users SET uname=?, email =?, password=?, role=?  WHERE id =?;");
				){
			
				ps.setString(1,obj.getUname());
				ps.setString(2, obj.getEmail());
				ps.setString(3, obj.getPassword());
				ps.setString(4, obj.getRole());
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
		try(Connection conn = ConnectionFactory.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement("Delete From users WHERE id =?;");
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
