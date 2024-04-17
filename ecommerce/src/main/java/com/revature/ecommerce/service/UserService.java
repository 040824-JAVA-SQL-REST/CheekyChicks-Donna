package com.revature.ecommerce.service;

import java.util.List;

import com.revature.ecommerce.dao.UserDAO;
import com.revature.ecommerce.models.User;

public class UserService {

	private UserDAO userDao;

	public UserService(UserDAO userDao) {
		this.userDao = userDao;
	}

	public boolean validateUsername(String uname) {
	 return uname.matches("[A-Za-z0-9]+");
		
	}

	public boolean ValidatePassword(String pw, String cpw) {

		return pw.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^*?&])[A-Za-z\\d@$!%^*?#&]{8,}$");
	}

	public boolean validateEmail(String email) {
		return email.matches(
				"^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$");
	}
	

	public boolean userNameExists(String uname) {
		List<User> userList = userDao.findall();

		return userList.stream().anyMatch(u -> u.getUname().equals(uname));
	}
	public void saveUser(User user) {
		userDao.save(user);
	}
	
	
	// ###########Private Helper Methods ####################
}
