package com.revature.wedding.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.revature.wedding.dao.ServiceDAO;
import com.revature.wedding.dao.UserDAO;
import com.revature.wedding.dao.WeddingDAO;
import com.revature.wedding.models.Service;
import com.revature.wedding.models.User;
import com.revature.wedding.models.Wedding;

public class WeddingServiceTestSuite {

	WeddingService sut;
	WeddingDAO mockWeddingDAO;
	UserDAO mockUserDAO;
	
	@Before
	public void testPrep() {
		mockWeddingDAO = mock(WeddingDAO.class);
		mockUserDAO = mock(UserDAO.class);
		sut = new WeddingService(mockWeddingDAO, mockUserDAO);
	}
	
	@Test
	public void test_insertWedding() {
		Wedding wedding = new Wedding();
		when(mockWeddingDAO.create(wedding)).thenReturn(true);
		assertTrue(sut.insertWedding(wedding));
	}
	
	@Test
	public void test_getAllWedding(){
		Wedding wedding1 = new Wedding();
		Wedding wedding2 = new Wedding();
		Wedding wedding3 = new Wedding();
		ArrayList<Wedding> weddings;
		weddings = new ArrayList<>();
		weddings.add(wedding1);
		weddings.add(wedding2);
		weddings.add(wedding3);
		
		when(mockWeddingDAO.selectAll()).thenReturn(weddings);
		
		weddings = (ArrayList<Wedding>)sut.getAllWedding();
		
		assertNotNull(weddings);
		assertFalse(weddings.isEmpty());
	}
	
	@Test
	public void test_getWeddingById() {
		Wedding wedding = new Wedding();
		when(mockWeddingDAO.selectById(1)).thenReturn(wedding);
		wedding = sut.getWeddingById(1);
		assertNotNull(wedding);
		wedding = sut.getWeddingById(0);
		assertNull(wedding);
	}
	
	@Test
	public void test_updateWedding() {
		Wedding wedding = new Wedding();
		sut.updateWedding(wedding);
		assertNotNull(wedding);
	}
	
	@Test
	public void test_deleteWedding() {
		Wedding wedding = new Wedding();
		sut.deleteWedding(1);
		assertNotNull(wedding);
	}
	
}
