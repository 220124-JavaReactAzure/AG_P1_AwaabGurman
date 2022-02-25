/**
 * 
 */
package com.revature.wedding.services;

import java.util.List;
import java.util.logging.Logger;

import com.revature.wedding.dao.ServiceTypeDAO;
import com.revature.wedding.models.ServiceType;

/**
 * @author Awaab Elamin
 * @date Feb 18, 2022
 * @update by:
 * @date 
 */
public class ServiceTypesServices {
	private final ServiceTypeDAO serviceTypeDAO;
	private Logger logger;


	/**
	 * @param serviceTypeDAO
	 */
	public ServiceTypesServices(ServiceTypeDAO serviceTypeDAO) {
		super();
		this.serviceTypeDAO = serviceTypeDAO;
		this.logger=Logger.getLogger("");
	}
	
	public boolean addServiceType(ServiceType serviceType) {
		logger.info("servicetypeservices inserting servicetype " + serviceType);
		return serviceTypeDAO.create(serviceType);
	}
	
	public List<ServiceType> getAllServiceTypes(){
		logger.info("servicetypeservices getting all servicetypes");
		return serviceTypeDAO.selectAll();
	}
	
	public ServiceType getServiceTypeById(int id){
		logger.info("servicetypeservices fetching servicetype with id " + id);
		return serviceTypeDAO.selectById(id);
	}
	
	public void updateServiceType(ServiceType serviceType) {
		logger.info("servicetypeservices updating servicetype " + serviceType);
		serviceTypeDAO.update(serviceType);
	}
	
	public boolean deleteServiceType(int id) {
		logger.info("servicetypeservices deleting servicetype with id " + id);
		return serviceTypeDAO.delete(id);
	}

}
