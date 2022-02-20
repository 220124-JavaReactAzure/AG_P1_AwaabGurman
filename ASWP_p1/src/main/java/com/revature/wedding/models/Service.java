/**
 * 
 */
package com.revature.wedding.models;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Awaab Elamin
 * @date Feb 18, 2022
 */
@Entity
@Table(name = "service")
public class Service {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "service_id")
	private int id;
	
	@Column(name = "service_name",nullable = false) 
	private String serviceName;
	
	@Column(name = "service_cost",nullable = false) 
	private Double serviceCost;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "service_types_id", nullable = false)
//	@Column(name = "service_types_id")
	@JsonIgnoreProperties(value= {"id"}) 
	public ServiceType serviceType;

	/**
	 * 
	 */
	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param serviceName
	 * @param serviceCost
	 * @param serviceType
	 */
	public Service(String serviceName, Double serviceCost, ServiceType serviceType) {
		super();
		this.serviceName = serviceName;
		this.serviceCost = serviceCost;
		this.serviceType = serviceType;
	}

	/**
	 * @param id
	 * @param serviceName
	 * @param serviceCost
	 * @param serviceType
	 */
	public Service(int id, String serviceName, Double serviceCost, ServiceType serviceType) {
		super();
		this.id = id;
		this.serviceName = serviceName;
		this.serviceCost = serviceCost;
		this.serviceType = serviceType;
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
	 * @return the serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * @param serviceName the serviceName to set
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * @return the serviceCost
	 */
	public Double getServiceCost() {
		return serviceCost;
	}

	/**
	 * @param serviceCost the serviceCost to set
	 */
	public void setServiceCost(Double serviceCost) {
		this.serviceCost = serviceCost;
	}

	/**
	 * @return the serviceType
	 */
	public ServiceType getServiceType() {
		return serviceType;
	}

	/**
	 * @param service the serviceType to set
	 */
	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, serviceCost, serviceName, serviceType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Service other = (Service) obj;
		return id == other.id && Objects.equals(serviceCost, other.serviceCost)
				&& Objects.equals(serviceName, other.serviceName) && Objects.equals(serviceType, other.serviceType);
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ", serviceName=" + serviceName + ", serviceCost=" + serviceCost + ", serviceType="
				+ serviceType + "]";
	}
	
	
}
