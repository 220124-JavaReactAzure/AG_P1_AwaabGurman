package com.revature.wedding_planner.services;

import java.util.List;

import com.revature.wedding_planner.daos.UserDAO;
import com.revature.wedding_planner.exceptions.AuthenticationException;
import com.revature.wedding_planner.exceptions.InvalidRequestException;
import com.revature.wedding_planner.exceptions.ResourcePersistenceException;
import com.revature.wedding_planner.models.User;

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
}
