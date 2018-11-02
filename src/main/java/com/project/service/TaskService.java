package com.project.service;

import java.util.List;

import com.project.entity.Task;

public interface TaskService {

	public List<Task> addTask(Task task);
	//public List<Task> deleteTask(long taskId);
	public List<Task> editTask(long taskId,Task task);
	public List<Task> viewTasks();
	public List<Task> sortTasks(long sortType);

}
