/**
 * 
 */
package com.revature.wedding.models;

import java.util.Objects;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author Awaab Elamin
 * @date Feb 20, 2022
 */
@Entity
@Table(name = "weddings")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//@JsonIgnoreProperties(value="service", allowGetters = true)
public class Wedding {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wedding_id")
	private int weddingId;

	@Column(name = "wedding_Name", nullable = false)
	private String weddingName;

	@Column(name = "wedding_date", nullable = false)
	private String date;

	@Column(name = "wedding_budget", nullable = false)
	private double budget;

//	(targetEntity = Service.class,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@OneToOne(targetEntity = Service.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(referencedColumnName = "service_id", nullable = true)
//	@JsonIgnoreProperties(value= {"id"}) 
//	(mappedBy = "creator", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@OneToOne
	@JoinColumn(name = "venuId", referencedColumnName = "service_id", nullable = true)
	@JsonIgnoreProperties(value= {"id","serviceType_Service"})
	private Service venuId;

//	(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
//	referencedColumnName = "service_id",
//	@OneToOne(targetEntity = Service.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@OneToOne
	@JoinColumn(name = "musicianId", referencedColumnName = "service_id", nullable = true)
	@JsonIgnoreProperties(value= {"id","serviceType_Service"})
	private Service musicianId;
//	
//	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@OneToOne
	@JoinColumn(name = "catererId", referencedColumnName = "service_id", nullable = true)
	@JsonIgnoreProperties(value= {"id","serviceType_Service"})
	private Service catererId;
//	
//	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@OneToOne
	@JoinColumn(name = "floristId", referencedColumnName = "service_id", nullable = true)
	@JsonIgnoreProperties(value= {"id","serviceType_Service"})
	private Service floristId;
//	
//	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@OneToOne
	@JoinColumn(name = "photographerId", referencedColumnName = "service_id", nullable = true)
	@JsonIgnoreProperties(value= {"id","serviceType_Service"})
	private Service photographerId;

	
	public Wedding() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param weddingName
	 * @param date
	 * @param budget
	 * @param venuId
	 * @param musicianId
	 * @param catererId
	 * @param floristId
	 * @param photographerId
	 */
	public Wedding(String weddingName, String date, double budget, Service venuId, Service musicianId,
			Service catererId, Service floristId, Service photographerId) {
		super();
		this.weddingName = weddingName;
		this.date = date;
		this.budget = budget;
		this.venuId = venuId;
		this.musicianId = musicianId;
		this.catererId = catererId;
		this.floristId = floristId;
		this.photographerId = photographerId;
	}



	/**
	 * @param id
	 * @param weddingName
	 * @param date
	 * @param budget
	 * @param venuId
	 * @param musicianId
	 * @param catererId
	 * @param florist_id
	 * @param photographerId
	 */
	public Wedding(int id, String weddingName, String date, double budget, Service venuId, Service musicianId,
			Service catererId, Service florist_id, Service photographerId) {
		super();
		this.weddingId = id;
		this.weddingName = weddingName;
		this.date = date;
		this.budget = budget;
		this.venuId = venuId;
		this.musicianId = musicianId;
		this.catererId = catererId;
		this.floristId = florist_id;
		this.photographerId = photographerId;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return weddingId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.weddingId = id;
	}

	/**
	 * @return the weddingName
	 */
	public String getWeddingName() {
		return weddingName;
	}

	/**
	 * @param weddingName the weddingName to set
	 */
	public void setWeddingName(String weddingName) {
		this.weddingName = weddingName;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the budget
	 */
	public double getBudget() {
		return budget;
	}

	/**
	 * @param budget the budget to set
	 */
	public void setBudget(double budget) {
		this.budget = budget;
	}

	/**
	 * @return the venuId
	 */
	public Service getVenuId() {
		return venuId;
	}

	/**
	 * @param venuId the venuId to set
	 */
	public void setVenuId(Service venuId) {
		this.venuId = venuId;
	}

	/**
	 * @return the musicianId
	 */
	public Service getMusicianId() {
		return musicianId;
	}

	/**
	 * @param musicianId the musicianId to set
	 */
	public void setMusicianId(Service musicianId) {
		this.musicianId = musicianId;
	}

	/**
	 * @return the catererId
	 */
	public Service getCatererId() {
		return catererId;
	}
	/**
	 * @param catererId the catererId to set
	 */

	public void setCatererId(Service catererId) {
		this.catererId = catererId;
	}

	/**
	 * @return the florist_id
	 */
	public Service getFlorist_id() {
		return floristId;
	}

	/**
	 * @param florist_id the florist_id to set
	 */
	public void setFlorist_id(Service florist_id) {
		this.floristId = florist_id;
	}

	/**
	 * @return the photographerId
	 */
	public Service getPhotographerId() {
		return photographerId;
	}

	/**
	 * @param photographerId the photographerId to set
	 */
	public void setPhotographerId(Service photographerId) {
		this.photographerId = photographerId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(budget, catererId, date, floristId, weddingId, musicianId, photographerId, venuId, weddingName);

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wedding other = (Wedding) obj;
		return Double.doubleToLongBits(budget) == Double.doubleToLongBits(other.budget)
				&& Objects.equals(catererId, other.catererId) && Objects.equals(date, other.date)
				&& Objects.equals(floristId, other.floristId) && weddingId == other.weddingId
				&& Objects.equals(musicianId, other.musicianId) && Objects.equals(photographerId, other.photographerId)
				&& Objects.equals(venuId, other.venuId) && Objects.equals(weddingName, other.weddingName);

	}

	@Override
	public String toString() {
		return "Wedding [id=" + weddingId + ", weddingName=" + weddingName + ", date=" + date + ", budget=" + budget
				+ ", venuId=" + venuId + ", musicianId=" + musicianId + ", catererId=" + catererId + ", florist_id="
				+ floristId + ", photographerId=" + photographerId + "]";

	}
}
