/**
 * 
 */
package com.revature.wedding.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Awaab Elamin
 * @date Feb 18, 2022
 */

@Entity
@Table(name = "service_types")
public class ServiceType {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "service_types_id")
	private int id;
	
	@Column(nullable = false)
	private String service;
	
//	@OneToMany(mappedBy="serviceType", fetch=FetchType.EAGER)
////	@JsonIgnoreProperties(value="serviceType")
//	private List<Service> allServices;

	/**
	 * 
	 */
	public ServiceType() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param service
	 * @param filmography
	 */
	public ServiceType(String service, List<Service> services) {
		super();
		this.service = service;
//		this.allServices = services;
	}
	

	/**
	 * @param id
	 * @param service
	 * @param allServices
	 */
	public ServiceType(int id, String service, List<Service> allServices) {
		super();
		this.id = id;
		this.service = service;
//		this.allServices = allServices;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the service
	 */
	public String getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(String service) {
		this.service = service;
	}

	/**
	 * @return the services
	 */
//	public List<Service> getservices() {
//		return allServices;
//	}

	/**
	 * @param filmography the services to set
	 */
//	public void setservices(List<Service> services) {
//		this.allServices = services;
//	}

	@Override
	public int hashCode() {
		return Objects.hash(id, service);
//		return Objects.hash(allServices, id, service);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceType other = (ServiceType) obj;
		return id == other.id && Objects.equals(service, other.service);
//		return Objects.equals(allServices, other.allServices) && id == other.id
//				&& Objects.equals(service, other.service);
	}

	@Override
	public String toString() {
		return "ServiceType [id=" + id + ", service=" + service + ", services=" + "]";
//		return "ServiceType [id=" + id + ", service=" + service + ", services=" + allServices + "]";
	}
	
	
	
}
