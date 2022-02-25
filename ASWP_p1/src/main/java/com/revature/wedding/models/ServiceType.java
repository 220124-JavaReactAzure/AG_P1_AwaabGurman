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
@Table(name = "service_types")
//@JsonIdentityInfo( // This helps witht he serialization to stop recursion with hibernate joins
//		generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ServiceType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "service_types_id")
	private int serviceTypeId;

	@Column(nullable = false)
	private String service;

	@OneToMany(mappedBy="serviceType_Service", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
//	@JsonIgnoreProperties(value="serviceType")
//	(mappedBy="serviceType", fetch=FetchType.EAGER)
//	@JoinColumn(name="service_service_types", nullable = true)
	@JsonIgnoreProperties(value={"id", "serviceServiceType","serviceTypeId"})
	private List<Service> serviceServiceType;

	/**
	 * 
	 */
	public ServiceType() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param service
	 * @param serviceServiceType
	 */
	public ServiceType(String service, List<Service> serviceServiceType) {
		super();
		this.service = service;
		this.serviceServiceType = serviceServiceType;
	}

	/**
	 * @param id
	 * @param service
	 * @param serviceServiceType
	 */
	public ServiceType(int id, String service, List<Service> serviceServiceType) {
		super();
		this.serviceTypeId = id;
		this.service = service;
		this.serviceServiceType = serviceServiceType;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return serviceTypeId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.serviceTypeId = id;
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
	 * @return the serviceServiceType
	 */
	public List<Service> getServiceServiceType() {
		return serviceServiceType;
	}

	/**
	 * @param serviceServiceType the serviceServiceType to set
	 */
	public void setServiceServiceType(List<Service> serviceServiceType) {
		this.serviceServiceType = serviceServiceType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(serviceTypeId, service, serviceServiceType);
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
		return serviceTypeId == other.serviceTypeId && Objects.equals(service, other.service)
				&& Objects.equals(serviceServiceType, other.serviceServiceType);
	}

	@Override
	public String toString() {
		return "ServiceType [id=" + serviceTypeId + ", service=" + service + "]";
	}

	

}
