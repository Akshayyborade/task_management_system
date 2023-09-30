package com.project.taskmanager.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.taskmanager.model.User;
import com.project.taskmanager.service.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService userService;
	@PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session) {
        if (userService.authenticateUser(email, password)) {
            // Redirect to home page after successful login
        	User user = userService.getUser(email);
        	session.setAttribute("user", user);
        	
            return "redirect:/user";
        } else {
            session.setAttribute("error", "Invalid credentials. Please try again.");
            return "login";
        }
    }


}
