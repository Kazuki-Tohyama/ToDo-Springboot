package com.example.todorest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ToDoRepository implements RepositoryInterface {
	List<Task> taskList = new ArrayList<Task>();

	@Override
	public List<Task> findAll() {
		return taskList;
	}

	@Override
	public void addItem(Task item) {
		taskList.add(item);
	}

	@Override
	public void deleteItem(int id) {
		taskList.remove(id);
	}
	
}