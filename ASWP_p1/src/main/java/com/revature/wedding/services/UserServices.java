package com.revature.wedding.services;

import java.util.List;

import com.revature.wedding.dao.UserDAO;
import com.revature.wedding.exception.AuthenticationException;
import com.revature.wedding.exception.InvalidRequestException;
import com.revature.wedding.exception.ResourcePersistenceException;
import com.revature.wedding.models.User;

public class UserServices {

	private UserDAO userDAO;
	
	public UserServices(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public boolean addUser(User user) {
		return userDAO.addUser(user);
	}
	
	public List<User> getAllUsers(){
		return userDAO.getAllUsers();
		
	}
	
	public User getUserById(int id){
		User user = userDAO.getUserById(id);
		return userDAO.getUserById(id);
	}
	
	
	public void updateUserWithSessionMethod(User user) {
		
		userDAO.updateUserWithSessionMethod(user);
	}
	
	public boolean deleteUserById(int id) {
		return userDAO.delete(id);
	}
	
	public boolean deleteUserByWddingId(int id) {
		return userDAO.deleteByWeddingId(id);
	}
}
