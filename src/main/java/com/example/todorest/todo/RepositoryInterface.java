package com.example.todorest.todo;

import java.util.List;

public interface RepositoryInterface {
	public List<Task> findAll();
	public void addItem(Task item);
	public void deleteItem(int id);
}
