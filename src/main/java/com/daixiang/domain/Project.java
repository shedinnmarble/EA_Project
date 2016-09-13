package com.daixiang.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity

public class Project {
	@Id
	@GeneratedValue
	private int Id;
	private String name;
	@Column(name="description")
	private String desc;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	 @Enumerated(EnumType.STRING)
	private Status status =Status.NEW;
	@ManyToOne
	private User owner;
	
	//@OneToMany
	@OneToMany(cascade=CascadeType.PERSIST)
	private List<Task> tasks=new ArrayList<Task>(); 
	public Project() {
		// TODO Auto-generated constructor stub
	}
	public Project(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	

}
