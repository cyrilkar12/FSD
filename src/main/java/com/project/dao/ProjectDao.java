package com.project.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Project;

@Repository
public interface ProjectDao<P> extends CrudRepository<Project,Long>  {
	public List<Project> findAllByOrderByStartDateAsc();
	public List<Project> findAllByOrderByEndDateAsc();
	public List<Project> findAllByOrderByPriorityAsc();

}
