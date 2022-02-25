/**
 * 
 */
package com.revature.wedding.services;

import java.util.List;
import java.util.logging.Logger;

import com.revature.wedding.dao.UserDAO;
import com.revature.wedding.dao.WeddingDAO;
import com.revature.wedding.models.Wedding;

/**
 * @author Awaab Elamin
 * @date Feb 20, 2022
 */
public class WeddingService {
	private final WeddingDAO weddingDAO;
	private Logger logger;
	
	//we need the userDao for deleting method
	private final UserDAO userDao;

	/**
	 * @param weddingDAO
	 */
	public WeddingService(WeddingDAO weddingDAO, UserDAO userDao) {
		super();
		this.weddingDAO = weddingDAO;
		this.userDao = userDao;
		this.logger=Logger.getLogger("");
	}
	
	public boolean insertWedding(Wedding wedding) {
		logger.info("weddingservices adding wedding " + wedding);
		return weddingDAO.create(wedding);
	}
	
	public List<Wedding> getAllWedding(){
		logger.info("weddingservices getting all weddings");
		return weddingDAO.selectAll();
	}
	
	public Wedding getWeddingById(int id) {
		logger.info("weddingservices getting wedding with id " + id);
		return weddingDAO.selectById(id);
	}
	
	public boolean updateWedding(Wedding wedding) {
		logger.info("weddingservices updating wedding " + wedding);
		return weddingDAO.update(wedding);
	}
	
	public boolean deleteWedding(int id) {
		//Before delete wedding, we need to delete all attendees from user table
		logger.info("weddingservices deleting wedding  with id " + id);
		return weddingDAO.delete(id);
	}

}
