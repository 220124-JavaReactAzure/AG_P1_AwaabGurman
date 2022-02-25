/**
 * 
 */
package com.revature.wedding.services;

import java.util.List;

import com.revature.wedding.dao.ServiceTypeDAO;
import com.revature.wedding.models.Service;
import com.revature.wedding.models.ServiceType;

/**
 * @author Awaab Elamin
 * @date Feb 18, 2022
 * @update by:
 * @date 
 */
public class ServiceTypesServices {
	private final ServiceTypeDAO serviceTypeDAO;

	/**
	 * @param serviceTypeDAO
	 */
	public ServiceTypesServices(ServiceTypeDAO serviceTypeDAO) {
		super();
		this.serviceTypeDAO = serviceTypeDAO;
	}
	
	public boolean addServiceType(ServiceType serviceType) {
		
		return serviceTypeDAO.create(serviceType);
	}
	
	public List<ServiceType> getAllServiceTypes(){
		return serviceTypeDAO.selectAll();
		
	}
	
	public ServiceType getServiceTypeById(int id){
		ServiceType serviceType = serviceTypeDAO.selectById(id);
		return serviceTypeDAO.selectById(id);
	}
	public void updateServiceType(ServiceType serviceType) {
		serviceTypeDAO.update(serviceType);
	}
	
	public boolean deleteServiceType(int id) {		
		return serviceTypeDAO.delete(id);
	}

}
