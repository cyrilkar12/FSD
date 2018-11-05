package com.project.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.project.entity.Project;

public class TestDataProject {
	
	public static Object[] provideProjects() {
    	Project project1 = new Project();
    	project1.setEndDate(new Date());
    	project1.setPriority(40);
    	project1.setProjectId(111);
    	project1.setStartDate(new Date());
    	//project1.setStatus("Completed");
    	Project project2 = new Project();
    	project2.setEndDate(new Date());
    	project2.setPriority(90);
    	project2.setProjectId(222);
    	project2.setStartDate(new Date());
    	//project2.setStatus("Inprogress");

		List<Project> projectList = new ArrayList<>();
		projectList.add(project1);
		projectList.add(project2);
		return (new Object[]{
				projectList
		}
				);
	}
	
	public static Object[] provideAddProjects() {
	   	Project project1 = new Project();
    	project1.setEndDate(new Date());
    	project1.setPriority(40);
    	project1.setProjectId(111);
    	project1.setStartDate(new Date());
    	//project1.setStatus("Completed");
    	Project project2 = new Project();
    	project2.setEndDate(new Date());
    	project2.setPriority(90);
    	project2.setProjectId(222);
    	project2.setStartDate(new Date());
    	//project2.setStatus("Inprogress");

		return (new Object[]{
				project1,project2
		}
				);
	}
	
	
	public static Object[] provideDelProjects() {
		

		return (new Object[]{
				111,222
		}
				);
	}

	
	public static Object[] provideEditProjects() {
	   	Project project1 = new Project();
    	project1.setEndDate(new Date());
    	project1.setPriority(40);
    	project1.setProjectId(111);
    	project1.setStartDate(new Date());
    	project1.setProject("COMS");
    	//project1.setStatus("Completed");
    	Project project2 = new Project();
    	project2.setEndDate(new Date());
    	project2.setPriority(90);
    	project2.setProject("TIM");
    	project2.setProjectId(222);
    	project2.setStartDate(new Date());
    	//project2.setStatus("Inprogress");

		return (new Object[][]{
				{project1,project1.getProject()},{project2,project2.getProject()}
		}
				);
	}
	
	
	public static Object[] provideProjectsForSort() {
	   	Project project1 = new Project();
    	project1.setEndDate(new Date());
    	project1.setPriority(40);
    	project1.setProjectId(111);
    	project1.setStartDate(new Date());
    	//project1.setStatus("Completed");
    	Project project2 = new Project();
    	project2.setEndDate(new Date());
    	project2.setPriority(90);
    	project2.setProjectId(222);
    	project2.setStartDate(new Date());
    	//project2.setStatus("Inprogress");

		List<Project> projectList = new ArrayList<>();
		projectList.add(project1);
		projectList.add(project2);
		return (new Object[][]{
				{projectList,1},{projectList,2},{projectList,3}
		}
				);
	}


}
