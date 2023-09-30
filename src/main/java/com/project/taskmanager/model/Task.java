package com.project.taskmanager.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tasks")
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)  
  private Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "due_date")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date dueDate;

  @Column(name = "status")
  private boolean status;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User assignedUser;

public Task(String title, String description, Date dueDate, boolean status, User assignedUser) {
	super();

	this.title = title;
	this.description = description;
	this.dueDate = dueDate;
	this.status = status;
	this.assignedUser = assignedUser;
}

public Task() {
	super();
	// TODO Auto-generated constructor stub
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Date getDueDate() {
	return dueDate;
}

public void setDueDate(Date dueDate) {
	this.dueDate = dueDate;
}

public boolean getStatus() {
	return status;
}

public void setStatus(boolean status) {
	this.status = status;
}

public User getAssignedUser() {
	return assignedUser;
}

public void setAssignedUser(User assignedUser) {
	this.assignedUser = assignedUser;
}

@Override
public String toString() {
	return "Task [id=" + id + ", title=" + title + ", description=" + description + ", dueDate=" + dueDate + ", status="
			+ status + ", assignedUser=" + assignedUser + "]";
}

  // Getters and setters

}
