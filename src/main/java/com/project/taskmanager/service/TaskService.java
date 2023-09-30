package com.project.taskmanager.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.taskmanager.dao.TaskDao;
import com.project.taskmanager.model.Task;
@Service
public class TaskService {
	@Autowired
	private TaskDao dao;
	public Long setTask(Task task) {
		return dao.saveTask(task);
		
	}
	public Task getTaskByTitle(String title) {
	   Task task = dao.findTaskByTitle(title);
	   return task;
   }
	public Task getTaskByDate(Date date) {
		   Task task = dao.findTaskByDate(date);
		   return task;
	   }
	public Task getTaskByStatus(String status) {
		   Task task = dao.findTaskByStatus(status);
		   System.out.println(task);
		   return task;
	   }
	public ArrayList<Task> getTask(String title,Date date,String f) {
		ArrayList<Task> task = dao.findTask(title,date,f);
		return task;
		
	}
	public List<Task> getTasksByUserId(Long userId) {
        return dao.findTasksByUserId(userId);
    }
	 public Task getTaskById(Long id) {
		 Task task = dao.getTaskById(id);
	        return task;
	    }

	    public void updateTask(Task task) {
	        dao.updateTask(task);
	    }
	    public void deleteTask(Long taskId) {
	        dao.deleteTask(taskId);
	    }

}
