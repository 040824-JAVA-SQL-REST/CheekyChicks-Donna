package com.revature.ecommerce.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.revature.ecommerce.models.User;

public class UserDAO implements CrudDAO<User> {
//CRUD operations Create Read Update Delete
	
	//for janky database
	private final String path= "src/main/resources/db/user.txt";
	
	
	@Override
	public void save(User obj) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
			bw.write(obj.convertToData());
			bw.newLine();
		}catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(User obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delte(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> findall() {
		List<User> users = new ArrayList<>();
		try (InputStream is = getClass().getClassLoader().getResourceAsStream("db/user.txt");
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader reader = new BufferedReader(isr)){
			

			String line;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split("/");
				users.add(new User(data));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User findByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
