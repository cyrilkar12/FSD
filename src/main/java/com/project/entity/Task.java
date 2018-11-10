package com.project.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Task")
public class Task {
	@Id
	@Column(name = "Task_Id")
	@GeneratedValue(strategy = GenerationType.AUTO) 
	long taskId;
	@ManyToOne
	@JoinColumn(name="Parent_Id")
	ParentTask parentTask;
	@ManyToOne
	@JoinColumn(name="Project_Id",nullable=false,insertable=false,updatable=false)
	Project project;
	@Column(name="Task")
	String task;
	@Column(name="Start_Date")
	Date startDate;
	@Column(name="End_Date")
	Date endDate;
	@Column(name="Priority")
	int priority;
	@Column(name="Status")
	String status;
	@OneToOne
	@JoinColumn(name="Task_Id",nullable=true,insertable=false,updatable=false)
//	@JsonBackReference
    User user;

	
	public long getTaskId() {
		return taskId;
	}
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}
	public ParentTask getParentTask() {
		return parentTask;
	}
	public void setParentTask(ParentTask parentTask) {
		this.parentTask = parentTask;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
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
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", parentTask=" + parentTask + ", project=" + project + ", task=" + task
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", priority=" + priority + ", status=" + status
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (taskId ^ (taskId >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (taskId != other.taskId)
			return false;
		return true;
	}
	

}
