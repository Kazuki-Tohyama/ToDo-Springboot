package com.example.todorest.web.todo;

import java.util.List;

public interface ServiceInterface {
	List<Task> getTaskList();
	void add(Task item);
	void delete(int id);
}
