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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

/**
 * @author Awaab Elamin
 * @date Feb 20, 2022
 */
@Entity
@Table(name = "weddings")
public class Wedding {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wedding_id")
	private int id;
	
	@Column(name = "wedding_Name", nullable = false)
	private String weddingName;
	
	@Column(name = "wedding_date", nullable = false)
	private String date;
	
	@Column(name = "wedding_budget")
	private double budget;
	
	@ManyToOne(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "service_id")
	private int venuId;
	
//	@ManyToOne(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "service_id")
//	private int musicianId;
//	
//	@ManyToOne(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "service_id")
//	private int catererId;
//	
//	@ManyToOne(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "service_id")
//	private int florist_id;
//	
//	@ManyToOne(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinColumn(name = "service_id")
//	private int photographerId;

	/**
	 * 
	 */
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
	 * @param florist_id
	 * @param photographerId
	 */
//	public Wedding(String weddingName, String date, double budget, int venuId, int musicianId, int catererId,
//			int florist_id, int photographerId) {
	public Wedding(String weddingName, String date, double budget, int venuId) {
		super();
		this.weddingName = weddingName;
		this.date = date;
		this.budget = budget;
		this.venuId = venuId;
//		this.musicianId = musicianId;
//		this.catererId = catererId;
//		this.florist_id = florist_id;
//		this.photographerId = photographerId;
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
//	public Wedding(int id, String weddingName, String date, double budget, int venuId, int musicianId, int catererId,
//			int florist_id, int photographerId) {
	public Wedding(int id, String weddingName, String date, double budget, int venuId) {
		super();
		this.id = id;
		this.weddingName = weddingName;
		this.date = date;
		this.budget = budget;
		this.venuId = venuId;
//		this.musicianId = musicianId;
//		this.catererId = catererId;
//		this.florist_id = florist_id;
//		this.photographerId = photographerId;
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
	public int getVenuId() {
		return venuId;
	}

	/**
	 * @param venuId the venuId to set
	 */
	public void setVenuId(int venuId) {
		this.venuId = venuId;
	}

	/**
	 * @return the musicianId
	 */
//	public int getMusicianId() {
//		return musicianId;
//	}

	/**
	 * @param musicianId the musicianId to set
	 */
//	public void setMusicianId(int musicianId) {
//		this.musicianId = musicianId;
//	}

	/**
	 * @return the catererId
	 */
//	public int getCatererId() {
//		return catererId;
//	}

	/**
	 * @param catererId the catererId to set
	 */
//	public void setCatererId(int catererId) {
//		this.catererId = catererId;
//	}

	/**
	 * @return the florist_id
	 */
//	public int getFlorist_id() {
//		return florist_id;
//	}

	/**
	 * @param florist_id the florist_id to set
	 */
//	public void setFlorist_id(int florist_id) {
//		this.florist_id = florist_id;
//	}

	/**
	 * @return the photographerId
	 */
//	public int getPhotographerId() {
//		return photographerId;
//	}

	/**
	 * @param photographerId the photographerId to set
	 */
//	public void setPhotographerId(int photographerId) {
//		this.photographerId = photographerId;
//	}

	@Override
//	public int hashCode() {
//		return Objects.hash(budget, catererId, date, florist_id, id, musicianId, photographerId, venuId, weddingName);
//	}
	public int hashCode() {
		return Objects.hash(budget, date, id, venuId, weddingName);
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
//		return Double.doubleToLongBits(budget) == Double.doubleToLongBits(other.budget) && catererId == other.catererId
//				&& Objects.equals(date, other.date) && florist_id == other.florist_id && id == other.id
//				&& musicianId == other.musicianId && photographerId == other.photographerId && venuId == other.venuId
//				&& Objects.equals(weddingName, other.weddingName);
		return Double.doubleToLongBits(budget) == Double.doubleToLongBits(other.budget) && Objects.equals(date, other.date) 
				&& venuId == other.venuId && Objects.equals(weddingName, other.weddingName);
	}

	@Override
	public String toString() {
//		return "Weddings [id=" + id + ", weddingName=" + weddingName + ", date=" + date + ", budget=" + budget
//				+ ", venuId=" + venuId + ", musicianId=" + musicianId + ", catererId=" + catererId + ", florist_id="
//				+ florist_id + ", photographerId=" + photographerId + "]";
		return "Weddings [id=" + id + ", weddingName=" + weddingName + ", date=" + date + ", budget=" + budget
				+ ", venuId=" + venuId + "]";
	}
}
