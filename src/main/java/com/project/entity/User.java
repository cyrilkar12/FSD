package com.project.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "User_Id")
	long userId;
	@Column(name = "First_Name")
	String firstName;
	@Column(name = "Last_Name")
	String lastName;
	@Column(name = "Employee_Id")
	int employeeId;
	@OneToMany
	@JoinColumn(name="Project_Id")
	Set<Project> project;
	@OneToMany
	@JoinColumn(name="Task_Id")
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
	public Set<Project> getProject() {
		return project;
	}
	public void setProject(Set<Project> project) {
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
				+ employeeId + ", project=" + project + ", tasks=" + tasks + "]";
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
