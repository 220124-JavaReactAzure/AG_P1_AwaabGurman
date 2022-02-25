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
import com.revature.wedding.models.MealType;
import com.revature.wedding.models.Service;

public class ServiceServicesTestSuite {

	ServiceServices sut;
	ServiceDAO mockServiceDAO;
	
	@Before
	public void testPrep() {
		mockServiceDAO = mock(ServiceDAO.class);
		sut = new ServiceServices(mockServiceDAO);
	}
	
	@Test
	public void test_insertservice() {
		Service service = new Service();
		when(mockServiceDAO.create(service)).thenReturn(true);
		assertTrue(sut.insertservice(service));
	}

	@Test
	public void test_getAllservices() {
		Service service1 = new Service();
		Service service2 = new Service();
		Service service3 = new Service();
		ArrayList<Service> services;
		services = new ArrayList<>();
		services.add(service1);
		services.add(service2);
		services.add(service3);
		
		when(mockServiceDAO.selectAll()).thenReturn(services);
		
		services = (ArrayList<Service>)sut.getAllservices();
		
		assertNotNull(services);
		assertFalse(services.isEmpty());
	}

	@Test
	public void test_getServiceById() {
		Service service = new Service();
		when(mockServiceDAO.selectById(1)).thenReturn(service);
		service = sut.getServiceById(1);
		assertNotNull(service);
		service = sut.getServiceById(0);
		assertNull(service);
	}

	@Test
	public void test_getServicesByServiceTypeId() {
		Service service1 = new Service();
		Service service2 = new Service();
		Service service3 = new Service();
		ArrayList<Service> services;
		services = new ArrayList<>();
		services.add(service1);
		services.add(service2);
		services.add(service3);
		
		when(mockServiceDAO.getServicesByServiceTypeId(1)).thenReturn(services);
		
		services = (ArrayList<Service>)sut.getServicesByServiceTypeId(1);
		
		assertNotNull(services);
		assertFalse(services.isEmpty());
	}
	
	@Test
	public void test_updateService() {
		Service service = new Service();
		sut.updateService(service);
		assertNotNull(service);
	}
	
	@Test
	public void test_deleteService() {
		Service service = new Service();
		sut.deleteService(service.getId());
		assertNotNull(service);
	}
}

