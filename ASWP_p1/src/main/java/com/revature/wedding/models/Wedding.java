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
<<<<<<< HEAD
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
=======
import javax.persistence.ManyToOne;
>>>>>>> fbb288c58113f6dd11057ce0ee6f26f4e003fddb
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

=======
>>>>>>> fbb288c58113f6dd11057ce0ee6f26f4e003fddb
/**
 * @author Awaab Elamin
 * @date Feb 20, 2022
 */
@Entity
@Table(name = "weddings")
<<<<<<< HEAD
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonIgnoreProperties(value="service", allowGetters = true)
public class Wedding {

=======
public class Wedding {
	
>>>>>>> fbb288c58113f6dd11057ce0ee6f26f4e003fddb
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wedding_id")
	private int id;
<<<<<<< HEAD

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
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "venuId", referencedColumnName = "service_id", nullable = true)
	private Service venuId;

//	(fetch= FetchType.EAGER, cascade = CascadeType.ALL)
//	referencedColumnName = "service_id",
//	@OneToOne(targetEntity = Service.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "musicianId", referencedColumnName = "service_id", nullable = true)
	private Service musicianId;
//	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "catererId", referencedColumnName = "service_id", nullable = true)
	private Service catererId;
//	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "floristId", referencedColumnName = "service_id", nullable = true)
	private Service floristId;
//	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "photographerId", referencedColumnName = "service_id", nullable = true)
	private Service photographerId;

	/**
	 * 
	 * 
	 **/
=======
	
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
>>>>>>> fbb288c58113f6dd11057ce0ee6f26f4e003fddb
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
<<<<<<< HEAD
	public Wedding(String weddingName, String date, double budget, Service venuId, Service musicianId,
			Service catererId, Service florist_id, Service photographerId) {
=======
//	public Wedding(String weddingName, String date, double budget, int venuId, int musicianId, int catererId,
//			int florist_id, int photographerId) {
	public Wedding(String weddingName, String date, double budget, int venuId) {
>>>>>>> fbb288c58113f6dd11057ce0ee6f26f4e003fddb
		super();
		this.weddingName = weddingName;
		this.date = date;
		this.budget = budget;
		this.venuId = venuId;
<<<<<<< HEAD
		this.musicianId = musicianId;
		this.catererId = catererId;
		this.floristId = florist_id;
		this.photographerId = photographerId;
=======
//		this.musicianId = musicianId;
//		this.catererId = catererId;
//		this.florist_id = florist_id;
//		this.photographerId = photographerId;
>>>>>>> fbb288c58113f6dd11057ce0ee6f26f4e003fddb
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
<<<<<<< HEAD
	public Wedding(int id, String weddingName, String date, double budget, Service venuId, Service musicianId,
			Service catererId, Service florist_id, Service photographerId) {
=======
//	public Wedding(int id, String weddingName, String date, double budget, int venuId, int musicianId, int catererId,
//			int florist_id, int photographerId) {
	public Wedding(int id, String weddingName, String date, double budget, int venuId) {
>>>>>>> fbb288c58113f6dd11057ce0ee6f26f4e003fddb
		super();
		this.id = id;
		this.weddingName = weddingName;
		this.date = date;
		this.budget = budget;
		this.venuId = venuId;
<<<<<<< HEAD
		this.musicianId = musicianId;
		this.catererId = catererId;
		this.floristId = florist_id;
		this.photographerId = photographerId;
=======
//		this.musicianId = musicianId;
//		this.catererId = catererId;
//		this.florist_id = florist_id;
//		this.photographerId = photographerId;
>>>>>>> fbb288c58113f6dd11057ce0ee6f26f4e003fddb
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
<<<<<<< HEAD
	public Service getVenuId() {
=======
	public int getVenuId() {
>>>>>>> fbb288c58113f6dd11057ce0ee6f26f4e003fddb
		return venuId;
	}

	/**
	 * @param venuId the venuId to set
	 */
<<<<<<< HEAD
	public void setVenuId(Service venuId) {
=======
	public void setVenuId(int venuId) {
>>>>>>> fbb288c58113f6dd11057ce0ee6f26f4e003fddb
		this.venuId = venuId;
	}

	/**
	 * @return the musicianId
	 */
<<<<<<< HEAD
	public Service getMusicianId() {
		return musicianId;
	}
=======
//	public int getMusicianId() {
//		return musicianId;
//	}
>>>>>>> fbb288c58113f6dd11057ce0ee6f26f4e003fddb

	/**
	 * @param musicianId the musicianId to set
	 */
<<<<<<< HEAD
	public void setMusicianId(Service musicianId) {
		this.musicianId = musicianId;
	}
=======
//	public void setMusicianId(int musicianId) {
//		this.musicianId = musicianId;
//	}
>>>>>>> fbb288c58113f6dd11057ce0ee6f26f4e003fddb

	/**
	 * @return the catererId
	 */
<<<<<<< HEAD
	public Service getCatererId() {
		return catererId;
	}
=======
//	public int getCatererId() {
//		return catererId;
//	}
>>>>>>> fbb288c58113f6dd11057ce0ee6f26f4e003fddb

	/**
	 * @param catererId the catererId to set
	 */
<<<<<<< HEAD
	public void setCatererId(Service catererId) {
		this.catererId = catererId;
	}
=======
//	public void setCatererId(int catererId) {
//		this.catererId = catererId;
//	}
>>>>>>> fbb288c58113f6dd11057ce0ee6f26f4e003fddb

	/**
	 * @return the florist_id
	 */
<<<<<<< HEAD
	public Service getFlorist_id() {
		return floristId;
	}
=======
//	public int getFlorist_id() {
//		return florist_id;
//	}
>>>>>>> fbb288c58113f6dd11057ce0ee6f26f4e003fddb

	/**
	 * @param florist_id the florist_id to set
	 */
<<<<<<< HEAD
	public void setFlorist_id(Service florist_id) {
		this.floristId = florist_id;
	}
=======
//	public void setFlorist_id(int florist_id) {
//		this.florist_id = florist_id;
//	}
>>>>>>> fbb288c58113f6dd11057ce0ee6f26f4e003fddb

	/**
	 * @return the photographerId
	 */
<<<<<<< HEAD
	public Service getPhotographerId() {
		return photographerId;
	}
=======
//	public int getPhotographerId() {
//		return photographerId;
//	}
>>>>>>> fbb288c58113f6dd11057ce0ee6f26f4e003fddb

	/**
	 * @param photographerId the photographerId to set
	 */
<<<<<<< HEAD
	public void setPhotographerId(Service photographerId) {
		this.photographerId = photographerId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(budget, catererId, date, floristId, id, musicianId, photographerId, venuId, weddingName);
=======
//	public void setPhotographerId(int photographerId) {
//		this.photographerId = photographerId;
//	}

	@Override
//	public int hashCode() {
//		return Objects.hash(budget, catererId, date, florist_id, id, musicianId, photographerId, venuId, weddingName);
//	}
	public int hashCode() {
		return Objects.hash(budget, date, id, venuId, weddingName);
>>>>>>> fbb288c58113f6dd11057ce0ee6f26f4e003fddb
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
<<<<<<< HEAD
		return Double.doubleToLongBits(budget) == Double.doubleToLongBits(other.budget)
				&& Objects.equals(catererId, other.catererId) && Objects.equals(date, other.date)
				&& Objects.equals(floristId, other.floristId) && id == other.id
				&& Objects.equals(musicianId, other.musicianId) && Objects.equals(photographerId, other.photographerId)
				&& Objects.equals(venuId, other.venuId) && Objects.equals(weddingName, other.weddingName);
=======
//		return Double.doubleToLongBits(budget) == Double.doubleToLongBits(other.budget) && catererId == other.catererId
//				&& Objects.equals(date, other.date) && florist_id == other.florist_id && id == other.id
//				&& musicianId == other.musicianId && photographerId == other.photographerId && venuId == other.venuId
//				&& Objects.equals(weddingName, other.weddingName);
		return Double.doubleToLongBits(budget) == Double.doubleToLongBits(other.budget) && Objects.equals(date, other.date) 
				&& venuId == other.venuId && Objects.equals(weddingName, other.weddingName);
>>>>>>> fbb288c58113f6dd11057ce0ee6f26f4e003fddb
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "Wedding [id=" + id + ", weddingName=" + weddingName + ", date=" + date + ", budget=" + budget
				+ ", venuId=" + venuId + ", musicianId=" + musicianId + ", catererId=" + catererId + ", florist_id="
				+ floristId + ", photographerId=" + photographerId + "]";
=======
//		return "Weddings [id=" + id + ", weddingName=" + weddingName + ", date=" + date + ", budget=" + budget
//				+ ", venuId=" + venuId + ", musicianId=" + musicianId + ", catererId=" + catererId + ", florist_id="
//				+ florist_id + ", photographerId=" + photographerId + "]";
		return "Weddings [id=" + id + ", weddingName=" + weddingName + ", date=" + date + ", budget=" + budget
				+ ", venuId=" + venuId + "]";
>>>>>>> fbb288c58113f6dd11057ce0ee6f26f4e003fddb
	}
}
