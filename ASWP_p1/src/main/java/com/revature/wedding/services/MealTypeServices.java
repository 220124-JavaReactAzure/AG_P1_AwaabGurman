package com.revature.wedding.services;

import java.util.List;

import com.revature.wedding.dao.MealTypeDAO;
import com.revature.wedding.models.MealType;

public class MealTypeServices {

	private final MealTypeDAO mealTypeDAO;
	
	public MealTypeServices(MealTypeDAO mealTypeDAO) {
		this.mealTypeDAO = mealTypeDAO;
	}
	
	public boolean addMealType(MealType mealType) {
		
		return mealTypeDAO.create(mealType);
	}
	
	public List<MealType> getAllMealTypes(){
		return mealTypeDAO.selectAll();
		
	}
	
	public MealType getMealTypeById(int id){
		return mealTypeDAO.selectById(id);
	}
	
	public void updateMeal(MealType mealType) {
		mealTypeDAO.update(mealType);
	}
}