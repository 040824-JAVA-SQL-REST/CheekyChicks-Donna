package com.revature.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;

import com.revature.ecommerce.dao.UserDAO;
import com.revature.ecommerce.models.User;

public class UserService {

	private UserDAO userDao;

	public UserService(UserDAO userDao) {
		this.userDao = userDao;
	}
// ##############    Validation    ################# 
	public boolean validateUsername(String uname) {
	 return uname.matches("[A-Za-z0-9]+");	
	}

	public boolean ValidatePassword(String pw) {
		return pw.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^*?&])[A-Za-z\\d@$!%^*?#&]{8,}$");
	}

	public boolean validateEmail(String email) {
		//RFC5322 Regex to validate email
		return email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
	}
	

	public boolean userNameExists(String uname) {
		List<User> userList = userDao.findall();
		return userList.stream().anyMatch(u -> u.getUname().equals(uname));
	}
	
	public boolean emailExists(String email) {
		List<User> userList = userDao.findall();
		return userList.stream().anyMatch(u -> u.getEmail().equals(email));
	}
	
	
	
	public User saveUser(User user) {
	
		String hashedPw = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(12));
		
		user.setPassword(hashedPw);
		return userDao.save(user);
	}
	
	public Optional<User> login(String userName, String password) {
		return userDao.findall().stream()
				.filter(u -> u.getUname().equals(userName) && BCrypt.checkpw(password, u.getPassword()))
				.findFirst();
	}
	
	// ###########Private Helper Methods ####################
}
