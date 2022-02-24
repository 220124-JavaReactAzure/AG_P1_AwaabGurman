/**
 * 
 */
package com.revature.wedding.services;

import java.util.List;

import com.revature.wedding.dao.UserDAO;
import com.revature.wedding.dao.WeddingDAO;
import com.revature.wedding.models.Wedding;

/**
 * @author Awaab Elamin
 * @date Feb 20, 2022
 */
public class WeddingService {
	private final WeddingDAO weddingDAO;
	
	//we need the userDao for deleting method
	private final UserDAO userDao;

	/**
	 * @param weddingDAO
	 */
	public WeddingService(WeddingDAO weddingDAO, UserDAO userDao) {
		super();
		this.weddingDAO = weddingDAO;
		this.userDao = userDao;
	}
	
	public boolean insertWedding(Wedding wedding) {
		return weddingDAO.create(wedding);
	}
	
	public List<Wedding> getAllWedding(){
		return weddingDAO.selectAll();
	}
	
	public Wedding getWeddingById(int id) {
		return weddingDAO.selectById(id);
	}
	
	public boolean updateWedding(Wedding wedding) {
		return weddingDAO.update(wedding);
	}
	
	public boolean deleteWedding(int id) {
		//Before delete wedding, we need to delete all attendees from user table
		
		return weddingDAO.delete(id);
	}

}
