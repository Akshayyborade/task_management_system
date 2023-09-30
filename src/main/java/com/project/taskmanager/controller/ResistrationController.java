package com.project.taskmanager.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.taskmanager.model.User;
import com.project.taskmanager.service.UserService;

@Controller
public class ResistrationController {
	@Autowired
	private UserService userService;

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String register(@RequestParam String name, @RequestParam String email, @RequestParam String password,
			@RequestParam String about, HttpSession session) {
		User user = new User();
		System.out.println(name);
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setAbout(about);
		if (userService.emailExists(email)) {
			session.setAttribute("error", "Email Already Registered");
			return "redirect:/register";
			
		}
		this.userService.createUser(user);
		session.setAttribute("msg", "registration sucessfull");
		return "redirect:/register" ;
	

		
	}
}
