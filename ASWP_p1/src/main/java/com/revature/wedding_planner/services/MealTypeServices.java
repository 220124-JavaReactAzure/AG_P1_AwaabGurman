package com.revature.wedding_planner.services;

import java.util.List;

import com.revature.wedding_planner.daos.MealTypeDAO;
import com.revature.wedding_planner.models.MealType;

public class MealTypeServices {

	private final MealTypeDAO mealTypeDAO;
	
	public MealTypeServices(MealTypeDAO mealTypeDAO) {
		this.mealTypeDAO = mealTypeDAO;
	}
	
	public boolean addServiceType(MealType mealType) {
		
		return mealTypeDAO.create(mealType);
	}
	
	public List<MealType> getAllMealTypes(){
		return MealTypeDAO.selectAll();
		
	}
	
	public MealType getMealTypeById(int id){
		return mealTypeDAO.selectById(id);
	}
	
	public void updateService(MealType serviceType) {
		mealTypeDAO.update(serviceType);
	}
}
