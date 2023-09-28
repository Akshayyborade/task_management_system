package com.project.taskmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResistrationController {
    @RequestMapping(path="/views/register", method = RequestMethod.POST)
	public String register(
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam String password
			) {
    	System.out.println(name);
		return "";
	}
}
