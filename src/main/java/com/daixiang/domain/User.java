package com.daixiang.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class User {
	@Id
	@GeneratedValue
	private int Id;
	private String firstName;
	private String lastName;
	@Enumerated(EnumType.STRING)
	private AdministrastorType userType;
	@OneToMany(cascade=CascadeType.PERSIST)
	private List<Project> projects=new ArrayList<Project>();
	@OneToMany(cascade=CascadeType.PERSIST)
	private List<Task> tasks=new ArrayList<Task>();
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String firstName, String lastName, AdministrastorType userType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userType = userType;
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
	public AdministrastorType getUserType() {
		return userType;
	}
	public void setUserType(AdministrastorType userType) {
		this.userType = userType;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}
