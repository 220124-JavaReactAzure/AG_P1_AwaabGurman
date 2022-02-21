package com.revature.wedding_planner.models;

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

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private String id;
	
	@Column(name = "name",nullable = false) 
	private String name;
	
	@Column(name = "email",nullable = false) 
	private String email;
	
	@Column(name = "meal_id",nullable = false) 
	private int meal_id;
	
	@Column(name = "plus_one",nullable = false) 
	private boolean plus_one;
	
	@Column(name = "plus_one_meal_id",nullable = false) 
	private int plus_one_meal_id;
	
	@Column(name = "wedding_id",nullable = false) 
	private int wedding_id;
	
	@Column(name = "betrothed",nullable = false) 
	private boolean betrothed;
	
	//Constructors
	
	public User(String id, String name, String email, int meal_id, boolean plus_one, int plus_one_meal_id,
			int wedding_id, boolean betrothed) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.meal_id = meal_id;
		this.plus_one = plus_one;
		this.plus_one_meal_id = plus_one_meal_id;
		this.wedding_id = wedding_id;
		this.betrothed = betrothed;
	}
	
	public User() {
		super();
	}
	
	//Getters and Setters

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getMeal_id() {
		return meal_id;
	}
	
	public void setMeal_id(int meal_id) {
		this.meal_id = meal_id;
	}
	
	public boolean isPlus_one() {
		return plus_one;
	}
	
	public void setPlus_one(boolean plus_one) {
		this.plus_one = plus_one;
	}
	
	public int getPlus_one_meal_id() {
		return plus_one_meal_id;
	}
	
	public void setPlus_one_meal_id(int plus_one_meal_id) {
		this.plus_one_meal_id = plus_one_meal_id;
	}
	
	public int getWedding_id() {
		return wedding_id;
	}
	
	public void setWedding_id(int wedding_id) {
		this.wedding_id = wedding_id;
	}
	
	public boolean isBetrothed() {
		return betrothed;
	}
	
	public void setBetrothed(boolean betrothed) {
		this.betrothed = betrothed;
	}

	@Override
	public int hashCode() {
		return Objects.hash(betrothed, email, meal_id, name, plus_one, plus_one_meal_id, wedding_id);
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
		return betrothed == other.betrothed && Objects.equals(email, other.email) && meal_id == other.meal_id
				&& Objects.equals(name, other.name) && plus_one == other.plus_one
				&& plus_one_meal_id == other.plus_one_meal_id && wedding_id == other.wedding_id;
	}
	
}
