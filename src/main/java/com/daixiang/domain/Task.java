package com.daixiang.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Task {

	@Id
	@GeneratedValue
	private int Id;
	private String taskName;
	@Enumerated(EnumType.STRING)
	private Status status=Status.NEW;
	private double timeframe;
	@Enumerated(EnumType.STRING)
	private ResourceType rescourceType;
	@OneToMany(cascade=CascadeType.PERSIST)
	private List<Beneficiarie> beneficiaries=new ArrayList<Beneficiarie>();
	@ManyToOne
	private User owner;
	@ManyToOne
	private Project project;
	public Task() {
		// TODO Auto-generated constructor stub
	}
	public Task(String taskName) {
		super();
		this.taskName = taskName;
		
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public double getTimeframe() {
		return timeframe;
	}
	public void setTimeframe(double timeframe) {
		this.timeframe = timeframe;
	}
	public ResourceType getRescourceType() {
		return rescourceType;
	}
	public void setRescourceType(ResourceType rescourceType) {
		this.rescourceType = rescourceType;
	}
	public List<Beneficiarie> getBeneficiaries() {
		return beneficiaries;
	}
	public void setBeneficiaries(List<Beneficiarie> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}

}
