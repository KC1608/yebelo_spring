package com.springrest.springrest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CategoryValues {

	@Id
	private int id;
	private String categoryCode;
	private int value; 
	
	
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}		
}

