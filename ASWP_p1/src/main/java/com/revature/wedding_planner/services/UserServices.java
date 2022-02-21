package com.revature.wedding_planner.services;

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
	
	
	public boolean registerNewUser(User user) throws ResourcePersistenceException {

        if (!isUserValid(user)) {
            throw new InvalidRequestException("Invalid user data provided!");
        }

        boolean usernameAvailable = userDAO.findByUsername(user.getName()) == null;
        boolean emailAvailable = userDAO.findByEmail(user.getEmail()) == null;

        if (!usernameAvailable || !emailAvailable) {
            String msg = "The values provided for the following fields are already taken by other users:";
            if (!usernameAvailable) msg = msg + "\n\t- username";
            if (!emailAvailable) msg = msg + "\n\t- email";
            throw new ResourcePersistenceException(msg);
        }

        boolean registeredUser = userDAO.create(user);

        if (!registeredUser) {
            throw new ResourcePersistenceException("The user could not be persisted to the datasource!");
        }
 
        return true;
    }
	
	public User authenticateUser(String username, String password) {

        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new InvalidRequestException("Invalid credential values provided!");
        }

        User authenticatedUser = userDAO.findByUsernameAndPassword(username, password);

        if (authenticatedUser == null) {
            throw new AuthenticationException("Unauthorized");
        }

        return authenticatedUser;

    }

    public boolean isUserValid(User user) {
        if (user == null) return false;
        if (user.getName() == null || user.getName().trim().equals("")) return false;
        if (user.getEmail() == null || user.getEmail().trim().equals("")) return false;
        return true;
    }
}
