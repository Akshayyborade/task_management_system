package com.project.taskmanager.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.taskmanager.model.User;

@Repository
public class UserDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
    @Transactional(readOnly = false)
    public Long saveUser(User user) {
        Serializable result = this.hibernateTemplate.save(user);

        if (result instanceof Long) {
            return (Long) result;  // Return the generated ID
        } else {
            throw new IllegalStateException("Unexpected return type from save: " + result.getClass());
        }
    }
    public User findByEmail(String email) {
    	List<User> users = (List<User>) hibernateTemplate.find("from User u where u.email=?0", email);
    	if (users.size()>0) {
			return users.get(0);
		}
    	return null;
    }
	public User findById(Long id) {
		List<User> users = (List<User>) hibernateTemplate.find("from User u where u.id=?0", id);
    	if (users.size()>0) {
			return users.get(0);
		}
    	return null;
	}
	public List<User> getUsers(){
		List<User> users =hibernateTemplate.loadAll(User.class);
		return users;
	}

}
