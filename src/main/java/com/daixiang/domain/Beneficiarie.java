package com.daixiang.domain;

import javax.persistence.Entity;
import javax.persistence.*;


@Entity
public class Beneficiarie {
	@Id
	@GeneratedValue
	private int Id;
	private String firstName;
	private String lastName;
	public Beneficiarie() {
		// TODO Auto-generated constructor stub
	}
	public Beneficiarie(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
