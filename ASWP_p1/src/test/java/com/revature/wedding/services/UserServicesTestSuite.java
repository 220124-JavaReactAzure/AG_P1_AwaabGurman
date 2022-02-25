package com.revature.wedding.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.revature.wedding.dao.ServiceDAO;
import com.revature.wedding.dao.UserDAO;
import com.revature.wedding.models.Service;
import com.revature.wedding.models.User;
import com.revature.wedding.models.Wedding;

public class UserServicesTestSuite {

	UserServices sut;
	UserDAO mockUserDAO;
	
	@Before
	public void testPrep() {
		mockUserDAO = mock(UserDAO.class);
		sut = new UserServices(mockUserDAO);
	}
	
	@Test
	public void test_addUser() {
		User user = new User();
		when(mockUserDAO.addUser(user)).thenReturn(true);
		assertTrue(sut.addUser(user));
	}
	
	@Test
	public void test_getAllUsers(){
		User user1 = new User();
		User user2 = new User();
		User user3 = new User();
		ArrayList<User> users;
		users = new ArrayList<>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
		when(mockUserDAO.getAllUsers()).thenReturn(users);
		
		users = (ArrayList<User>)sut.getAllUsers();
		
		assertNotNull(users);
		assertFalse(users.isEmpty());
	}
	
	@Test
	public void test_getUserById(){
		User user = new User();
		when(mockUserDAO.getUserById(1)).thenReturn(user);
		user = sut.getUserById(1);
		assertNotNull(user);
		user = sut.getUserById(0);
		assertNull(user);
	}
	
	@Test
	public void test_updateUserWithSessionMethod() {
		User user = new User();
		sut.updateUserWithSessionMethod(user);
		assertNotNull(user);
	}
	
	@Test
	public void test_deleteUserByID() {
		User user = new User();
		sut.deleteUserById(user.getId());
		assertNotNull(user);
	}
	
	@Test
	public void test_deleteUserByWeddingId() {
		User user = new User();
		Wedding wedding = new Wedding();
		user.setWedding_id(wedding);
		sut.deleteUserByWddingId(user.getWedding_id().getId());
		assertNotNull(user);
	}
	
}

