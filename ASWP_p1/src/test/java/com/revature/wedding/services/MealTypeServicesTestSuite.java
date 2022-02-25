/**
 * 
 */
package com.revature.wedding.services;

/**
 * @author Awaab Elamin
 * @date Feb 24, 2022
 */
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.revature.wedding.dao.MealTypeDAO;
import com.revature.wedding.models.MealType;

public class MealTypeServicesTestSuite {

	MealTypeServices sut;
	MealTypeDAO mockMealTypeDAO;

	@Before
	public void testPrep() {
		mockMealTypeDAO = mock(MealTypeDAO.class);
		sut = new MealTypeServices(mockMealTypeDAO);
	}

	@Test
	public void test_addMealType() {
		MealType mealType = new MealType();
		when(mockMealTypeDAO.create(mealType)).thenReturn(true);
		assertTrue(sut.addMealType(mealType));
	}

	@Test
	public void test_getAllMealTypes() {
		MealType mealType1 = new MealType();
		MealType mealType2 = new MealType();
		MealType mealType3 = new MealType();
		ArrayList<MealType> mealTypes;
		mealTypes = new ArrayList<>();
		mealTypes.add(mealType1);
		mealTypes.add(mealType2);
		mealTypes.add(mealType3);

		when(mockMealTypeDAO.selectAll()).thenReturn(mealTypes);

		mealTypes = (ArrayList<MealType>) sut.getAllMealTypes();

		assertNotNull(mealTypes);
		assertFalse(mealTypes.isEmpty());
	}

	@Test
	public void test_getMealTypeById() {
		MealType mealType = new MealType();
		when(mockMealTypeDAO.selectById(1)).thenReturn(mealType);
		mealType = sut.getMealTypeById(1);
		assertNotNull(mealType);
		mealType = sut.getMealTypeById(0);
		assertNull(mealType);
	}

	@Test
	public void test_updateMeal() {
		MealType mealType = new MealType();
		sut.updateMeal(mealType);
		assertNotNull(mealType);
	}
	@Test
	public void test_deleteMeal() {
		MealType mealType = new MealType();
		sut.deleteMealType(mealType.getId());
		assertNotNull(mealType);
	}
}

