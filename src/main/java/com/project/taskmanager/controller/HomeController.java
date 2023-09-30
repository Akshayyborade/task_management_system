package com.project.taskmanager.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.taskmanager.model.Task;
import com.project.taskmanager.service.TaskService;

@Controller
public class HomeController {
	@Autowired
	private TaskService taskService;
	
    @RequestMapping("/")
	public String home() {
    	return "index";
    }
   @GetMapping("/register")
   public String register() {
	   return "registration";
   }
   @GetMapping("/login")
   public String login() {
	   return "login";
   }
   @GetMapping("/user")
   public String user() {
	   return "user/user";
   }
   @GetMapping("/addTask")
   public String task() {
	   return "user/addTask";
   }
   @GetMapping("/editTask")
   public String editTask(Model model, @RequestParam("id") Long taskId) {
       Task task = taskService.getTaskById(taskId);
       model.addAttribute("task", task);
       return "user/editTask"; // Assuming your JSP file is named "editTask.jsp"
   }
   @GetMapping("/logOut")
   public String logOutUser(HttpSession session) {
	   session.invalidate();
	   
	   return "login" ; 
   }
  
 

}
