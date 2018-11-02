package com.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ProjectDao;
import com.project.entity.Project;
import com.project.service.ProjectService;

@Service
public class  ProjectServiceImpl implements ProjectService {
	
	@Autowired
	ProjectDao<Project> projectDao;

	@Override
	public List<Project> addProject(Project project) {
		projectDao.save(project);
		return viewProjects();
	}

	@Override
	public List<Project> deleteProject(long projectId) {
		projectDao.delete(projectId);
		return viewProjects();
	}

	@Override
	public List<Project> editProject(long projectId, Project project) {
		projectDao.save(project);
		return viewProjects();
	}

	@Override
	public List<Project> viewProjects() {
		Iterable<Project> lstItr = projectDao.findAll();
		List<Project> lstProjects = new ArrayList<>();
		lstItr.forEach(lstProjects::add);
		return lstProjects;
	}

	@Override
	public List<Project> sortProjects(long sortType) {
		// TODO Auto-generated method stub
		Iterable<Project> lstItr = null;
		List<Project> lstProjects = new ArrayList<>();
		if(sortType ==1) {
			lstItr = projectDao.findAllByOrderByStartDateAsc();
		}else if(sortType ==2) {
			lstItr = projectDao.findAllByOrderByEndDateAsc();
		}else if(sortType ==3) {
			lstItr = projectDao.findAllByOrderByPriorityAsc();
		}else {
			lstItr = projectDao.findAllByOrderByStartDateAsc();
		}
		
		lstItr.forEach(lstProjects::add);
		return lstProjects;
	}

	
}
