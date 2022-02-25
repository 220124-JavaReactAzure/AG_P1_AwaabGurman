package com.revature.wedding.services;

import java.util.List;
import java.util.logging.Logger;

import com.revature.wedding.dao.MealTypeDAO;
import com.revature.wedding.models.MealType;

public class MealTypeServices {

	private final MealTypeDAO mealTypeDAO;
	private Logger logger;
	
	public MealTypeServices(MealTypeDAO mealTypeDAO) {
		this.mealTypeDAO = mealTypeDAO;
		this.logger=Logger.getLogger("");
	}
	
	public boolean addMealType(MealType mealType) {
		logger.info("mealtypeservice adding mealType " + mealType);
		return mealTypeDAO.create(mealType);
	}
	
	public List<MealType> getAllMealTypes(){
		logger.info("mealtypeservice getting all mealTypes");
		return mealTypeDAO.selectAll();
		
	}
	
	public MealType getMealTypeById(int id){
		logger.info("mealtypeservice fetching mealType with id " + id);
		return mealTypeDAO.selectById(id);
	}
	
	public void updateMeal(MealType mealType) {
		logger.info("mealtypeservice updating mealType " + mealType);
		mealTypeDAO.update(mealType);
	}
	public boolean deleteMealType(int id) {
		logger.info("mealtypeservice deleting mealType with id " + id);
		return mealTypeDAO.delete(id);
	}
}