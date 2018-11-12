package com.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Project;
import com.project.entity.Task;

@Repository
public interface TaskDao<P> extends CrudRepository<Task,Long> {
	public List<Task> findAllByOrderByStartDateAsc();
	public List<Task> findAllByOrderByEndDateAsc();
	public List<Task> findAllByOrderByPriorityAsc();
	public List<Task> findByTaskNameContainingIgnoreCase(String taskName);
	@Query(value ="select * from test.task where parent_id=?1",nativeQuery=true )
	public List<Task> findByParentTaskId(long parentId);
}
