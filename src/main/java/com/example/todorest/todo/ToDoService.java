package com.example.todorest.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService implements ServiceInterface {
	private final RepositoryInterface repository;
	
	@Autowired
	public ToDoService(ToDoRepository repository) {
		this.repository = repository;
	}
	
	public List<Task> getTaskList() {
		return repository.findAll();
	}

	public void add(Task item) {
		repository.addItem(item);
	}

	public void delete(int id) {
		repository.deleteItem(id);		
	}

}