/**
 * 
 */
package com.revature.wedding.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author Awaab Elamin
 * @date Feb 18, 2022
 */
@Cacheable
//@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Entity
@Table(name = "service")
//@JsonIgnoreProperties(value="serviceType", allowGetters = true)
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Service {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "service_id")
	private int serviceId;
	
	@Column(name = "service_name",nullable = false) 
	private String serviceName;
	
	@Column(name = "service_cost",nullable = false) 
	private Double serviceCost;
	
//	@OneToMany(mappedBy = "serviceServiceType", fetch = FetchType.LAZY)
//	@JoinColumn(name = "service_service_types", nullable = false)
//	@Column(name = "service_types_id")
//	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="serviceTypeService", nullable = true)
	@JsonIgnoreProperties(value= {"id"}) 
	private ServiceType serviceType_Service;

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
	 * @param serviceType_Service
	 */
	public Service(String serviceName, Double serviceCost, ServiceType serviceType_Service) {
		super();
		this.serviceName = serviceName;
		this.serviceCost = serviceCost;
		this.serviceType_Service = serviceType_Service;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return serviceId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.serviceId = id;
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
	 * @return the serviceType_Service
	 */
	public ServiceType getServiceType_Service() {
		return serviceType_Service;
	}

	/**
	 * @param serviceType_Service the serviceType_Service to set
	 */
	public void setServiceType_Service(ServiceType serviceType_Service) {
		this.serviceType_Service = serviceType_Service;
	}

	@Override
	public int hashCode() {
		return Objects.hash(serviceId, serviceCost, serviceName, serviceType_Service);
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
		return serviceId == other.serviceId && Objects.equals(serviceCost, other.serviceCost)
				&& Objects.equals(serviceName, other.serviceName)
				&& Objects.equals(serviceType_Service, other.serviceType_Service);
	}

	@Override
	public String toString() {
		return "Service [id=" + serviceId + ", serviceName=" + serviceName + ", serviceCost=" + serviceCost + "]";
	}
	

	
}
