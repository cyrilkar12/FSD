package com.project.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Users")
public class User {

	@Id
    @Column(name = "User_Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	long userId;
	@Column(name = "First_Name")
	String firstName;
	@Column(name = "Last_Name")
	String lastName;
	@Column(name = "Employee_Id")
	int employeeId;
	//@JoinColumn(name="Project_Id",nullable=true,insertable=false,updatable=false)
	@OneToOne
	//@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "user")
	@JoinColumn(name="Project_Id",nullable=true,insertable=false,updatable=true)
	@JsonIgnore
	//@JsonBackReference
	Project project;
	@OneToMany
	@JoinColumn(name="Task_Id",nullable=true,insertable=false,updatable=false)
	@JsonIgnore
	//@JsonManagedReference
	Set<Task> tasks;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
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
	public int getEmployeeId() {
		return this.employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Set<Task> getTasks() {
		return tasks;
	}
	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	
	/*
	 * public class Node {
    @Id
    private Integer id;
    private String nameNode;
    @OneToMany
    @JoinColumn(name = "idAuthorites", referencedColumnName = "idAuthorites", insertable=false, updatable=false)
    private Set<Authority> authorities;
    ...

public class Authority {
    @Id
    private AuthorityPK pk;
    private String person;
    @OneToMany
    @JoinColumn(name = "idAuthorites", referencedColumnName = "idAuthorites")
    private Set<Node> nodes;
    ...*/
	 public User() {
		 
	 }
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", EmployeeId="
				+ employeeId + "]";
	}
	
	@Override
	public int hashCode() {
		final long prime = 31;
		long result = 1;
		result = prime * result + employeeId;
		result = prime * result + userId;
		return (int)result;
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
		if (userId != other.userId)
			return false;
		return true;
	}
	
}
