package com.project.springcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Task;
import com.project.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskRestController {
	@Autowired
	TaskService taskService;
	
	@RequestMapping(value = "/addTask",
			method = RequestMethod.POST,produces = "application/json")
	 @ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public List<Task> addTask(@RequestBody Task task){
		return taskService.addTask(task);
	}
	
	/*@RequestMapping(value = "/deleteTask/{id}", method = RequestMethod.DELETE,produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Task> deleteTask(@PathVariable("id") long taskId){
		return taskService.deleteTask(taskId);
	}*/
	
	@RequestMapping(value = "/editTask/{id}", method = RequestMethod.PUT,produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Task> editTask(@PathVariable("id") long taskId,@RequestBody Task task) {
		return taskService.editTask(taskId, task);
	}

	@RequestMapping(value = "/viewTasks",
			method = RequestMethod.GET,produces = "application/json")
	 @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Task> viewTasks() {
		return taskService.viewTasks();
	}
	
	@RequestMapping(value = "/sortTasks/{sorttype}",
			method = RequestMethod.GET,produces = "application/json")
	 @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Task> sortTasks(@PathVariable("sorttype") long sortType) {
		return taskService.sortTasks(sortType);
	}

}
