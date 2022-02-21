package com.revature.wedding_planner.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class MealType {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "meal_id",nullable = false)
	private int id;
	
	@Column(name = "service",nullable = false)
	private String meal_type;
	
	//Constructor
	
	public MealType(int id, String meal_type) {
		super();
		this.id = id;
		this.meal_type = meal_type;
	}
	
	public MealType() {
		super();
	}

	//Getters and Setters
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getMeal_type() {
		return meal_type;
	}
	
	public void setMeal_type(String meal_type) {
		this.meal_type = meal_type;
	}
	
	
}
