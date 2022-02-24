/**
 * 
 */
package com.revature.wedding.services;

import java.util.List;

import com.revature.wedding.dao.ServiceDAO;
import com.revature.wedding.models.Service;

/**
 * @author Awaab Elamin
 * @date Feb 18, 2022
 */
public class ServiceServices {
	private final ServiceDAO serviceDAO;

	public ServiceServices(ServiceDAO serviceDAO) {
		this.serviceDAO = serviceDAO;
	}

	public boolean insertservice(Service service) {
		return serviceDAO.create(service);
	}

	public List<Service> getAllservices() {
		return serviceDAO.selectAll();
	}

	public Service getServiceById(int id) {

		Service service = serviceDAO.selectById(id);
		return service;
	}

	public List<Service> getServicesByServiceTypeId(int id) {
		return serviceDAO.getServicesByServiceTypeId(id);
	}
	public void updateService(Service service) {
		serviceDAO.update(service);
	}
	public boolean deleteService(int id) {		
		return serviceDAO.delete(id);
	}
}
