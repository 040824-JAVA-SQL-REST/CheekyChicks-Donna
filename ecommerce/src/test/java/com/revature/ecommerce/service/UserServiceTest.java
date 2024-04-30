package com.revature.ecommerce.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.revature.ecommerce.dao.UserDAO;

public class UserServiceTest {
	
		UserDAO dao = Mockito.mock(UserDAO.class);
		UserService s = new UserService(dao);
	@Before
	public void setup() {
		
	}
	@Test
	public void validate_userName_whenCorrect() {
		String username = "UserName";
		assertTrue(s.validateUsername(username));
		
	}
	@Test
	public void validate_userName_whenBlank() {
		String username = "";
		assertFalse(s.validateUsername(username));
		
	}
	@Test public void validatePassword_whenCorrect() {
		String password = "Password!2";
		assertTrue(s.ValidatePassword(password));
	}
	
	@Test public void validatePassword_whenIncorrect() {
		String password = "Password!";
		assertFalse(s.ValidatePassword(password));
	}
	@Test public void validatePassword_whenBlank() {
		String password = "";
		assertFalse(s.ValidatePassword(password));
	}
	
	
	

}
