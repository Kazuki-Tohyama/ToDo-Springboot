package com.example.todorest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ToDoController {
	List<Task> taskList = new ArrayList<Task>();
	
	@ModelAttribute("taskList")
	public List<Task> setUpTaskList() {
		return taskList;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	@PostMapping("/addtask")
	public String addTask(@ModelAttribute Task newTask, Model model) {
		taskList.add(newTask);
		return "redirect:/";
	}
	
	@PostMapping("/deletetask")
	public String deleteTask(@RequestParam int id, Model model) {
		taskList.remove(id);
		return "redirect:/";
	}
	
}
