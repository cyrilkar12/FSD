package com.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.TaskDao;
import com.project.entity.Task;
import com.project.service.TaskService;

@Service
public class  TaskServiceImpl implements TaskService {
	
	@Autowired
	TaskDao<Task> taskDao;

	@Override
	public List<Task> addTask(Task task) {
		taskDao.save(task);
		return viewTasks();
	}

	/*@Override
	public List<Task> deleteTask(long taskId) {
		taskDao.delete(taskId);
		return viewTasks();
	}*/

	@Override
	public List<Task> editTask(long taskId, Task task) {
		taskDao.save(task);
		return viewTasks();
	}

	@Override
	public List<Task> viewTasks() {
		Iterable<Task> lstItr = taskDao.findAll();
		List<Task> lstTasks = new ArrayList<>();
		lstItr.forEach(lstTasks::add);
		return lstTasks;
	}

	@Override
	public List<Task> sortTasks(long sortType) {
		// TODO Auto-generated method stub
		Iterable<Task> lstItr = null;
		List<Task> lstTasks = new ArrayList<>();
		if(sortType ==1) {
			lstItr = taskDao.findAllByOrderByStartDateAsc();
		}else if(sortType ==2) {
			lstItr = taskDao.findAllByOrderByEndDateAsc();
		}else if(sortType ==3) {
			lstItr = taskDao.findAllByOrderByPriorityAsc();
		}else {
			lstItr = taskDao.findAllByOrderByStartDateAsc();
		}
		
		lstItr.forEach(lstTasks::add);
		return lstTasks;
	}

	
}
