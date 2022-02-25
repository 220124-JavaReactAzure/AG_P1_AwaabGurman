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
import com.revature.wedding.dao.ServiceTypeDAO;
import com.revature.wedding.models.Service;
import com.revature.wedding.models.ServiceType;

public class ServiceTypesServicesTestSuite {

	ServiceTypesServices sut;
	ServiceTypeDAO mockServiceTypeDAO;

	@Before
	public void testPrep() {
		mockServiceTypeDAO = mock(ServiceTypeDAO.class);
		sut = new ServiceTypesServices(mockServiceTypeDAO);
	}

	@Test
	public void test_addServiceType() {
		ServiceType serviceType = new ServiceType();
		when(mockServiceTypeDAO.create(serviceType)).thenReturn(true);
		assertTrue(sut.addServiceType(serviceType));
	}

	@Test
	public void test_getAllServiceTypes() {
		ServiceType serviceType1 = new ServiceType();
		ServiceType serviceType2 = new ServiceType();
		ServiceType serviceType3 = new ServiceType();
		ArrayList<ServiceType> serviceTypes;
		serviceTypes = new ArrayList<>();
		serviceTypes.add(serviceType1);
		serviceTypes.add(serviceType2);
		serviceTypes.add(serviceType3);

		when(mockServiceTypeDAO.selectAll()).thenReturn(serviceTypes);

		serviceTypes = (ArrayList<ServiceType>) sut.getAllServiceTypes();

		assertNotNull(serviceTypes);
		assertFalse(serviceTypes.isEmpty());
	}

	@Test
	public void test_getServiceTypeById() {
		ServiceType serviceType = new ServiceType();
		when(mockServiceTypeDAO.selectById(1)).thenReturn(serviceType);
		serviceType = sut.getServiceTypeById(1);
		assertNotNull(serviceType);
		serviceType = sut.getServiceTypeById(0);
		assertNull(serviceType);
	}

	@Test
	public void test_updateServiceType() {
		ServiceType serviceType = new ServiceType();
		sut.updateServiceType(serviceType);
		assertNotNull(serviceType);
	}

	@Test
	public void test_deleteServiceType() {
		ServiceType serviceType = new ServiceType();
		sut.deleteServiceType(serviceType.getId());
		assertNotNull(serviceType);
	}
}