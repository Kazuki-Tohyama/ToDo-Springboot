package com.example.todorest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ToDoController {
	List<Task> taskList = new ArrayList<Task>();
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("taskList", taskList);
		model.addAttribute("newTask", new Task());
		return "index";
	}
	
	@PostMapping("/addtask")
	public String add(@ModelAttribute Task newTask, Model model) {
		taskList.add(newTask);
		return "redirect:/";
	}
	
}
