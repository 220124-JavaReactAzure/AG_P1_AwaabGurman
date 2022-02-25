/**
 * 
 */
package com.revature.wedding.services;

import java.util.List;
import java.util.logging.Logger;

import com.revature.wedding.dao.ServiceDAO;
import com.revature.wedding.models.Service;

/**
 * @author Awaab Elamin
 * @date Feb 18, 2022
 */
public class ServiceServices {
	private final ServiceDAO serviceDAO;
	private Logger logger;

	public ServiceServices(ServiceDAO serviceDAO) {
		this.serviceDAO = serviceDAO;
		this.logger=Logger.getLogger("");
	}

	public boolean insertservice(Service service) {
		logger.info("serviceservices inserting service " + service);
		return serviceDAO.create(service);
	}

	public List<Service> getAllservices() {
		logger.info("serviceservices getting all services");
		return serviceDAO.selectAll();
	}

	public Service getServiceById(int id) {
		logger.info("serviceservices fetching service with id " + id);
		Service service = serviceDAO.selectById(id);
		return service;
	}

	public List<Service> getServicesByServiceTypeId(int id) {
		logger.info("serviceservices fetching services with service type id " + id);
		return serviceDAO.getServicesByServiceTypeId(id);
	}
	public void updateService(Service service) {
		logger.info("serviceservices updating service " + service);
		serviceDAO.update(service);
	}
	public boolean deleteService(int id) {
		logger.info("serviceservices deleting service with id" + id);
		return serviceDAO.delete(id);
	}
}
