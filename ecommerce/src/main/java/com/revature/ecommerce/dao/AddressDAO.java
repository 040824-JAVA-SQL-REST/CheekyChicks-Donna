package com.revature.ecommerce.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.revature.ecommerce.models.Address;
import com.revature.ecommerce.utilities.ConnectionFactory;

public class AddressDAO implements CrudDAO<Address> {

	

	@Override
	public List<Address> findall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address findByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Address save(Address obj) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement("INSERT INTO address (id,street,street2, city, state, country, postalcode) VALUES(?,?,?,?,?,?,?)")
				;){
				ps.setString(1, obj.getId());
				ps.setString(2, obj.getStreet());
				ps.setString(3, obj.getStreet2());
				ps.setString(4, obj.getCity());
				ps.setString(5, obj.getState());
				ps.setString(6, obj.getCountry());
				ps.setString(7, obj.getPostalcode());
				
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
	public Address update(Address obj) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
