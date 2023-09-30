package com.project.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.taskmanager.dao.UserDao;
import com.project.taskmanager.model.User;

@Service
public class UserService {
	@Autowired
	private UserDao dao;

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	public Long createUser(User user) {
		// UserDao dao = new UserDao();
		return dao.saveUser(user);
	}

	public boolean emailExists(String email) {
		return dao.findByEmail(email) != null;
	}
	public boolean authenticateUser(String email, String password) {
        User user = dao.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }
	public User getUser(String email) {
		User user = dao.findByEmail(email);
		return user;
	}
   public User getUserById(Long id) {
	   User user = dao.findById(id);
	   return user;
	   
	   
   }
}
