package com.revature.wedding.services;

import java.util.List;
import java.util.logging.Logger;

import com.revature.wedding.dao.UserDAO;
import com.revature.wedding.models.User;

public class UserServices {

	private UserDAO userDAO;
	private Logger logger;
	
	public UserServices(UserDAO userDAO) {
		this.userDAO = userDAO;
		this.logger=Logger.getLogger("");
	}
	
	public boolean addUser(User user) {
		logger.info("userservices adding user " + user);
		return userDAO.addUser(user);
	}
	
	public List<User> getAllUsers(){
		logger.info("userservices getting all users");
		return userDAO.getAllUsers();
		
	}
	
	public User getUserById(int id){
		logger.info("userservices fetching user with id " + id);
		return userDAO.getUserById(id);
	}
	
	
	public void updateUserWithSessionMethod(User user) {
		logger.info("userservices updating " + user);
		userDAO.updateUserWithSessionMethod(user);
	}
	
	public boolean deleteUserById(int id) {
		logger.info("userservices deleting user with id " + id);
		return userDAO.delete(id);
	}
	
	public boolean deleteUserByWddingId(int id) {
		logger.info("userservices deleting user with wedding id " + id);
		return userDAO.deleteByWeddingId(id);
	}
}
