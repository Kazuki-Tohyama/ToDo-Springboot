package com.example.todorest.web.todo;

import java.util.List;

public interface RepositoryInterface {
	public List<Task> findAll();
	public void addItem(Task item);
	public void deleteItem(int id);
}
