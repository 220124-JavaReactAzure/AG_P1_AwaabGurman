package com.revature.wedding_planner.models;

import java.util.Objects;

public class User {

	private String name;
	private String email;
	private int meal_id;
	private boolean plus_one;
	private int plus_one_meal_id;
	private int wedding_id;
	private boolean betrothed;
	
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
