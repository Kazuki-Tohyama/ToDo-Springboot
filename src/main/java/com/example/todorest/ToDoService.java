package com.example.todorest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService implements ServiceInterface {
	private final ToDoRepository todoRepository;
	
	@Autowired
	public ToDoService(ToDoRepository repository) {
		this.todoRepository = repository;
	}
	
	
	public List<Task> getTaskList() {
		return todoRepository.findAll();
	}

	public void add(Task item) {
		todoRepository.addItem(item);
	}

	public void delete(int id) {
		todoRepository.deleteItem(id);		
	}

}