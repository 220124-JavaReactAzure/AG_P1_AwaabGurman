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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "app_users")
//@JsonIgnoreProperties(value="mealType", allowGetters = true)
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int user_id;
	
	@Column(name = "legal_name",nullable = false) 
	private String name;
	
	@Column(name = "outlook_email",nullable = false,unique = true) 
	private String email;
	
	@Column(name = "plus_one",nullable = false) 
	private boolean plus_one;
	
	@Column(name = "plus_one_meal_id",nullable = false) 
	private int plus_one_meal_id;
	
	
	@OneToOne
	@JoinColumn(name = "wedd_Id", referencedColumnName = "wedding_id", nullable = true)
	private Wedding wedd_id;
	
	@Column(name = "betrothed",nullable = false) 
	private boolean betrothed;
	
//	@OneToMany(targetEntity = MealType.class)
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mealId", nullable = true, referencedColumnName = "meal_id")
	private MealType mealType;
	
	
	
	public User() {
		super();
	}

	public User(String name, String email, boolean plus_one, int plus_one_meal_id, Wedding wedding_id, boolean betrothed,
			MealType mealType) {
		super();
		this.name = name;
		this.email = email;
		this.plus_one = plus_one;
		this.plus_one_meal_id = plus_one_meal_id;
		this.wedd_id = wedding_id;
		this.betrothed = betrothed;
		this.mealType = mealType;
	}

	
	
	public User(int id, String name, String email, boolean plus_one, int plus_one_meal_id, Wedding wedding_id,
			boolean betrothed, MealType mealType) {
		super();
		this.user_id = id;
		this.name = name;
		this.email = email;
		this.plus_one = plus_one;
		this.plus_one_meal_id = plus_one_meal_id;
		this.wedd_id = wedding_id;
		this.betrothed = betrothed;
		this.mealType = mealType;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return user_id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.user_id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the plus_one
	 */
	public boolean isPlus_one() {
		return plus_one;
	}

	/**
	 * @param plus_one the plus_one to set
	 */
	public void setPlus_one(boolean plus_one) {
		this.plus_one = plus_one;
	}

	/**
	 * @return the plus_one_meal_id
	 */
	public int getPlus_one_meal_id() {
		return plus_one_meal_id;
	}

	/**
	 * @param plus_one_meal_id the plus_one_meal_id to set
	 */
	public void setPlus_one_meal_id(int plus_one_meal_id) {
		this.plus_one_meal_id = plus_one_meal_id;
	}

	/**
	 * @return the wedding_id
	 */
	public Wedding getWedding_id() {
		return wedd_id;
	}

	/**
	 * @param wedding_id the wedding_id to set
	 */
	public void setWedding_id(Wedding wedding_id) {
		this.wedd_id = wedding_id;
	}

	/**
	 * @return the betrothed
	 */
	public boolean isBetrothed() {
		return betrothed;
	}

	/**
	 * @param betrothed the betrothed to set
	 */
	public void setBetrothed(boolean betrothed) {
		this.betrothed = betrothed;
	}

	/**
	 * @return the mealType
	 */
	public MealType getMealType() {
		return mealType;
	}

	/**
	 * @param mealType the mealType to set
	 */
	public void setMealType(MealType mealType) {
		this.mealType = mealType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(betrothed, email, user_id, mealType, name, plus_one, plus_one_meal_id, wedd_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return betrothed == other.betrothed && Objects.equals(email, other.email) && user_id == other.user_id
				&& Objects.equals(mealType, other.mealType) && Objects.equals(name, other.name)
				&& plus_one == other.plus_one && plus_one_meal_id == other.plus_one_meal_id
				&& wedd_id == other.wedd_id;
	}

	@Override
	public String toString() {
		return "User [id=" + user_id + ", name=" + name + ", email=" + email + ", plus_one=" + plus_one
				+ ", plus_one_meal_id=" + plus_one_meal_id + ", wedding_id=" + wedd_id + ", betrothed=" + betrothed
				+ "]";
	}

	
	
}
