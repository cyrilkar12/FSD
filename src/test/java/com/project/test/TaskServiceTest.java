package com.project.test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

import com.project.WebApplication;
import com.project.dao.TaskDao;
import com.project.entity.Task;
import com.project.service.TaskService;

import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
//@WebMvcTest(controllers = {TaskRestController.class}, secure=false)
@SpringBootTest(classes = WebApplication.class)
//@ContextConfiguration(classes = WebApplication.class)
public class TaskServiceTest {
	
    @ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

	@Autowired(required=true)
	TaskService taskService;
	
	@MockBean
	TaskDao<Task> taskRepository; 
	
List<Task> lstTasks= new ArrayList<>();
    
    @Before
	public void setUp() {
    	Task task1 = new Task();
    	task1.setEndDate(new Date());
    	task1.setPriority(40);
    	task1.setTaskId(111);
    	task1.setStartDate(new Date());
    	task1.setTask("COMS1");
    	task1.setStatus("Completed");
    	lstTasks.add(task1);
    	Task task2 = new Task();
    	task2.setEndDate(new Date());
    	task2.setPriority(40);
    	task2.setTaskId(111);
    	task2.setTask("COMS2");
    	task2.setStartDate(new Date());
    	task2.setStatus("Completed");
    	lstTasks.add(task2);
    }
	
	@Test
    @junitparams.Parameters(source= TestDataTask.class, method = "provideAddTasks")
	public void testAddTask(Task addtask) {
		Mockito.when(taskRepository.save(addtask))
	      .thenReturn(addtask);
		lstTasks.add(addtask);
		Mockito.when(taskRepository.findAll())
	      .thenReturn(lstTasks);
		lstTasks = taskService.addTask(addtask);
		boolean lstSucccess = true;
		if(!lstTasks.contains(addtask)) {
			lstSucccess = false;
		}
		assertTrue("Task add Failed", lstSucccess);

	}
	
/*	@Test
    @junitparams.Parameters(source= TestDataTask.class, method = "provideDelTasks")
	public void testDeleteTask(long taskId) {
		Mockito.when(taskRepository.findAll())
	      .thenReturn(lstTasks);
		lstTasks = taskService.deleteTask(taskId);
		ArgumentCaptor<Long> valueCapture = ArgumentCaptor.forClass(Long.class);
		Mockito.verify(taskRepository).delete( valueCapture.capture());
		long argTaskId = valueCapture.getValue();
		Task delTask = new Task();
		delTask.setTaskId(argTaskId);
		boolean avail = lstTasks.remove(delTask);
		boolean lstSucccess = false;
		if(avail && !lstTasks.contains(delTask)) {
			lstSucccess = true;
		}
		assertTrue("Task del Failed", lstSucccess);

	}*/
	
	@Test
    @junitparams.Parameters(source= TestDataTask.class, method = "provideEditTasks")
	public void testEditTask(Task edittask,String expectedEditTaskName) {
		Mockito.when(taskRepository.save(edittask))
	      .thenReturn(edittask);
		lstTasks.add(edittask);
		Mockito.when(taskRepository.findAll())
	      .thenReturn(lstTasks);
		lstTasks = taskService.editTask(edittask.getTaskId(), edittask);
		boolean lstSucccess = true;
		String actulEditTaskName= null;
		if(!lstTasks.contains(edittask)) {
			actulEditTaskName = lstTasks.get(lstTasks.indexOf(edittask)).getTask();
			lstSucccess = false;
		}
		assertTrue("Task add Failed", lstSucccess);
		assertFalse(expectedEditTaskName.equals(actulEditTaskName));

	}


	@Test
    @junitparams.Parameters(source= TestDataTask.class, method = "provideTasks")
	public void testviewTasks(List<Task> expectedLstTask) {
		Mockito.when(taskRepository.findAll())
	      .thenReturn(lstTasks);
		lstTasks = taskService.viewTasks();
		boolean lstSucccess = true;
		if(!expectedLstTask.containsAll(lstTasks)) {
			lstSucccess = false;
		}
		assertTrue("Task Viewing failed", lstSucccess);
	}
	
	@Test
    @junitparams.Parameters(source= TestDataTask.class, method = "provideTasksForSort")
	public void testSortTasks(List<Task> expectedLstTask,int sortType) {
		Mockito.when(taskRepository.findAllByOrderByStartDateAsc())
	      .thenReturn(lstTasks);
		Mockito.when(taskRepository.findAllByOrderByEndDateAsc())
	      .thenReturn(lstTasks);
		Mockito.when(taskRepository.findAllByOrderByPriorityAsc())
	      .thenReturn(lstTasks);
		lstTasks = taskService.sortTasks(sortType);
		boolean lstSucccess = true;
		if(!expectedLstTask.containsAll(lstTasks)) {
			lstSucccess = false;
		}
		assertTrue("Task Sorting failed", lstSucccess);
	}
	

}
