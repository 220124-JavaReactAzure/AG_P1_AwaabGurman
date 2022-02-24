/**
 * 
 */
package com.revature.wedding.services;

import java.util.List;

import com.revature.wedding.dao.WeddingDAO;
import com.revature.wedding.models.Wedding;

/**
 * @author Awaab Elamin
 * @date Feb 20, 2022
 */
public class WeddingService {
	private final WeddingDAO weddingDAO;

	/**
	 * @param weddingDAO
	 */
	public WeddingService(WeddingDAO weddingDAO) {
		super();
		this.weddingDAO = weddingDAO;
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
		return weddingDAO.delete(id);
	}

}
