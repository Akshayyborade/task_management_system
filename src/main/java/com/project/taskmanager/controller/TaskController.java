package com.project.taskmanager.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.taskmanager.model.Task;
import com.project.taskmanager.model.User;
import com.project.taskmanager.service.TaskService;
import com.project.taskmanager.service.UserService;

@Controller
@RequestMapping("/user")
public class TaskController {
	@Autowired
	TaskService taskService;
	@Autowired
	UserService userService;

	@PostMapping("/saveTask")
	public String taskSave(

			@RequestParam String title, @RequestParam String description, @RequestParam String dueDate,
			@RequestParam(value = "status", defaultValue = "false") boolean status, @RequestParam String assignedUser) {
		Date parsedDueDate;
		Task task;

		try {
			Long assignedId = Long.parseLong(assignedUser);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			parsedDueDate = dateFormat.parse(dueDate);
			User assignUser = userService.getUserById(assignedId);
			task = new Task(title, description, parsedDueDate, status, assignUser);
			Long setTask = taskService.setTask(task);
		} catch (ParseException e) {
			// Handle the parsing error
			e.printStackTrace();
			// You can add error handling logic here
			return "redirect:/user/errorPage"; // Redirect to an error page
		}

		return "redirect:/addTask";
	}

	@PostMapping("/showTask")
	public String showTask(@RequestParam String title, @RequestParam String status, @RequestParam String due_date,
			HttpSession session) {

		User user = (User) session.getAttribute("user");
		List<Task> tasks;

		try {
			if (user != null) {
				Long userId = user.getId();
				tasks = taskService.getTasksByUserId(userId);

				// Filter tasks based on the provided criteria
				tasks = filterTasks(tasks, title, status, due_date);

				session.setAttribute("tasks", tasks);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/user";
	}

	private List<Task> filterTasks(List<Task> tasks, String title, String status, String due_date) {
		List<Task> filteredTasks = new ArrayList<>();

		for (Task task : tasks) {
			boolean addTask = true;

			// Filter by title
			if (title != null && !title.isEmpty()) {
				if (!task.getTitle().toLowerCase().contains(title.toLowerCase())) {
					addTask = false;
				}
			}

			// Filter by status
			if (status != null && !status.isEmpty()) {
				if (!String.valueOf(task.getStatus()).equals(status)) {
					addTask = false;
				}
			}

			// Add the task if it meets the filtering criteria
			if (addTask) {
				filteredTasks.add(task);
			}
		}

		return filteredTasks;
	}

	@PostMapping("/updateTask")
	public String editTask(@ModelAttribute Task task) {

		taskService.updateTask(task);
		return "redirect:/user";

	}
	@PostMapping("/deleteTask")
    public String deleteTask(@RequestParam("taskId") Long taskId , HttpSession session) {
        taskService.deleteTask(taskId);
        session.removeAttribute("tasks");
        
        return "redirect:/user"; // Redirect to the user page after deleting
    }

}
