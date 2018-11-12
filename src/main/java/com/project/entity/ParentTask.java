package com.project.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Parent_Task")
public class ParentTask {
	@Id
	@Column(name = "Parent_Id")
	int parentTaskId;
	@Column(name = "Parent_Task")
	String parentTaskName;
	@OneToMany(cascade= {CascadeType.ALL} ,fetch = FetchType.EAGER, mappedBy="parentTask")
	//@JoinColumn(cascade= {CascadeType.ALL} ,fetch = FetchType.EAGER, mappedBy="project")
	@JsonIgnore
	Set<Task> taskSet;
	
	public Set<Task> getTaskSet() {
		return taskSet;
	}
	public void setTaskSet(Set<Task> taskSet) {
		this.taskSet = taskSet;
	}
	public int getparentTaskId() {
		return parentTaskId;
	}
	public void setparentTaskId(int parentTaskId) {
		this.parentTaskId = parentTaskId;
	}
	public String getParentTaskName() {
		return parentTaskName;
	}
	public void setParentTaskName(String parentTaskName) {
		this.parentTaskName = parentTaskName;
	}

}
