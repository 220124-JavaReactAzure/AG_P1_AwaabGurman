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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "meal_type")
@JsonIdentityInfo( // This helps with he serialization to stop recursion with hibernate joins
		generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class MealType {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "meal_id")
	private int meal_id;
	
	@Column(nullable = false)
	private String meal_type;
	
	//Constructor
	
	public MealType(String meal_type) {
		this.meal_type = meal_type;
	}
	
	public MealType(int id, String meal_type) {
		super();
		this.meal_id = id;
		this.meal_type = meal_type;
	}
	
	public MealType() {
		super();
	}

	//Getters and Setters
	
	public int getId() {
		return meal_id;
	}
	
	public void setId(int id) {
		this.meal_id = id;
	}
	
	public String getMeal_type() {
		return meal_type;
	}
	
	public void setMeal_type(String meal_type) {
		this.meal_type = meal_type;
	}

	//Hash
	
	@Override
	public int hashCode() {
		return Objects.hash(meal_id, meal_type);
	}

	//Equals
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MealType other = (MealType) obj;
		return meal_id == other.meal_id && Objects.equals(meal_type, other.meal_type);
	}

	//ToString
	
	@Override
	public String toString() {
		return "MealType [id=" + meal_id + ", meal_type=" + meal_type + "]";
	}
		
}
