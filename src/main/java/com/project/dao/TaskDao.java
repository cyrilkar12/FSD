package com.project.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Task;

@Repository
public interface TaskDao<P> extends CrudRepository<Task,Long> {
	public List<Task> findAllByOrderByStartDateAsc();
	public List<Task> findAllByOrderByEndDateAsc();
	public List<Task> findAllByOrderByPriorityAsc();

}
