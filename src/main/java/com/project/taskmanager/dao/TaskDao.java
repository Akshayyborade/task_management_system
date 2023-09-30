package com.project.taskmanager.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.taskmanager.model.Task;

@Repository
public class TaskDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional(readOnly = false)
	public Long saveTask(Task task) {
		 Serializable result = this.hibernateTemplate.save(task);
	        if (result instanceof Long) {
	            return (Long) result;  // Return the generated ID
	        } else {
	            throw new IllegalStateException("Unexpected return type from save: " + result.getClass());
	        }
	        
    
	}

	public Task findTaskByTitle(String title) {
	    
		this.hibernateTemplate.delete(title);;
		return null;
		
	}

	public Task findTaskByDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	public Task findTaskByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public ArrayList<Task> findTask(String title, Date date, String status) {
		ArrayList<Task> tasks = new ArrayList<Task>();
		try {
			tasks = (ArrayList<Task>) this.hibernateTemplate.find("from Task t where t.title=?0 or t.dueDate=?1 or t.status=?2", title, date, status);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return tasks;
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Task> findTasksByUserId(Long userId) {
        return (List<Task>) hibernateTemplate.find("from Task t where t.assignedUser.id = ?0", userId);
    }
	
	public Task getTaskById(Long id) {
		Task task = (Task) hibernateTemplate.get(Task.class, id);
		System.out.println(task);
        return task;
    }

    public void updateTask(Task task) {
        hibernateTemplate.update(task);
    }
    @Transactional(readOnly = false)
    public void deleteTask(Long taskId) {
        Task task = hibernateTemplate.get(Task.class, taskId);
        if (task != null) {
            hibernateTemplate.delete(task);
        }
    }

	
}
