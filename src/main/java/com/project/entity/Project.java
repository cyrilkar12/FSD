package com.project.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/*@SqlResultSetMapping(
	    name = "findAllDataMapping",
	    classes = @ConstructorResult(
	            targetClass = Project.class,
	            columns = {
	                    @ColumnResult(name = "userFirstName"),
	                    @ColumnResult(name = "userLastName"),
	                    @ColumnResult(name = "id"),
	                    @ColumnResult(name = "packageName")
	            }
	    )
	)
@NamedNativeQuery(name = "findAllDataMapping", resultClass = Project.class, resultSetMapping ="findAllDataMapping", query = "select p.project_id,p.Project,p.start_date,p.end_date,p.priority,count(distinct t.task_id) as numberOfTasks, \\n\" + \n" + 
		"			\"(select count(distinct t.task_id) from test.task where project_id=p.project_id and status='Completed') as completedTasks \\n\" + \n" + 
		"			\" from test.project p inner join test.task t \\n\" + \n" + 
		"			\"on p.project_id=t.project_id group by p.project_id,p.Project,p.start_date,p.end_date,p.priority")
*/
@Entity
@Table(name="Project")
public class Project {
	@Id
    @Column(name = "Project_Id")
	long projectId;
	 @Column(name = "Project")
	String project;
	 @Column(name = "Start_Date")
	Date startDate;
	 @Column(name = "End_Date")
	Date endDate;
	 @Column(name = "Priority")
	int priority;
/*	@Column(name = "Status")
	String status;
*/	@JsonIgnore
	@OneToMany(mappedBy="project")
	private Set<Task> taskSet;
    /*@JsonProperty
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Transient*/
	@Formula("(select count(distinct t.task_id) from test.task t where t.project_id=project_id)")
    int numberOfTasks;
/*	@JsonProperty 
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Transient*/
	@Formula("(select count(distinct t.task_id) from test.task t where t.project_id=project_id and t.status='Completed')")
    int completedTasks;
    
/*	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
*/	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
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
	public int getNumberOfTasks() {
		return numberOfTasks;
	}
	public void setNumberOfTasks(int numberOfTasks) {
		this.numberOfTasks = numberOfTasks;
	}
	public int getCompletedTasks() {
		return completedTasks;
	}
	public void setCompletedTasks(int completedTasks) {
		this.completedTasks = completedTasks;
	}
	public Set<Task> getTaskSet() {
		return taskSet;
	}
	public void setTaskSet(Set<Task> taskSet) {
		this.taskSet = taskSet;
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", project=" + project + ", startDate=" + startDate + ", endDate="
				+ endDate + ", priority=" + priority + ", numberOfTasks=" + numberOfTasks
				+ ", completedTasks=" + completedTasks + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (projectId ^ (projectId >>> 32));
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
		Project other = (Project) obj;
		if (projectId != other.projectId)
			return false;
		return true;
	}
}
