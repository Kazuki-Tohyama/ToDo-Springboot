package com.example.todorest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ToDoController {	
	private final ToDoService todoService;
	
	@Autowired
	public ToDoController(ToDoService todoService) {
		this.todoService = todoService;
	}
	
	@ModelAttribute("taskList")
	public List<Task> setUpTaskList() {
		return todoService.getTaskList();
	}
	
	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	@PostMapping("/addtask")
	public String addTask(@ModelAttribute Task newTask, Model model) {
		todoService.add(newTask);
		return "redirect:/";
	}
	
	@PostMapping("/deletetask")
	public String deleteTask(@ModelAttribute("id") int id, Model model) {
		todoService.delete(id);
		return "redirect:/";
	}
	
}
