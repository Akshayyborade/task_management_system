package com.project.taskmanager.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
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
   public String editTask() {
	   return "user/editTask";
   }
   @GetMapping("/logOut")
   public String logOutUser(HttpSession session) {
	   session.invalidate();
	   
	   return "login" ; 
   }
  
 

}
