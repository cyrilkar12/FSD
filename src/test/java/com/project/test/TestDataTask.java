package com.project.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.project.entity.Task;

public class TestDataTask {
	
	public static Object[] provideTasks() {
    	Task task1 = new Task();
    	task1.setEndDate(new Date());
    	task1.setPriority(40);
    	task1.setTaskId(111);
    	task1.setStartDate(new Date());
    	task1.setStatus("Completed");
    	Task task2 = new Task();
    	task2.setEndDate(new Date());
    	task2.setPriority(90);
    	task2.setTaskId(222);
    	task2.setStartDate(new Date());
    	task2.setStatus("Inprogress");

		List<Task> taskList = new ArrayList<>();
		taskList.add(task1);
		taskList.add(task2);
		return (new Object[]{
				taskList
		}
				);
	}
	
	public static Object[] provideAddTasks() {
	   	Task task1 = new Task();
    	task1.setEndDate(new Date());
    	task1.setPriority(40);
    	task1.setTaskId(111);
    	task1.setStartDate(new Date());
    	task1.setStatus("Completed");
    	Task task2 = new Task();
    	task2.setEndDate(new Date());
    	task2.setPriority(90);
    	task2.setTaskId(222);
    	task2.setStartDate(new Date());
    	task2.setStatus("Inprogress");

		return (new Object[]{
				task1,task2
		}
				);
	}
	
	
	public static Object[] provideDelTasks() {
		

		return (new Object[]{
				111,222
		}
				);
	}

	
	public static Object[] provideEditTasks() {
	   	Task task1 = new Task();
    	task1.setEndDate(new Date());
    	task1.setPriority(40);
    	task1.setTaskId(111);
    	task1.setStartDate(new Date());
    	task1.setTaskName("COMS");
    	task1.setStatus("Completed");
    	Task task2 = new Task();
    	task2.setEndDate(new Date());
    	task2.setPriority(90);
    	task2.setTaskName("TIM");
    	task2.setTaskId(222);
    	task2.setStartDate(new Date());
    	task2.setStatus("Inprogress");

		return (new Object[][]{
				{task1,task1.getTaskName()},{task2,task2.getTaskName()}
		}
				);
	}
	
	
	public static Object[] provideTasksForSort() {
	   	Task task1 = new Task();
    	task1.setEndDate(new Date());
    	task1.setPriority(40);
    	task1.setTaskId(111);
    	task1.setStartDate(new Date());
    	task1.setStatus("Completed");
    	Task task2 = new Task();
    	task2.setEndDate(new Date());
    	task2.setPriority(90);
    	task2.setTaskId(222);
    	task2.setStartDate(new Date());
    	task2.setStatus("Inprogress");

		List<Task> taskList = new ArrayList<>();
		taskList.add(task1);
		taskList.add(task2);
		return (new Object[][]{
				{taskList,1},{taskList,2},{taskList,3}
		}
				);
	}


}
