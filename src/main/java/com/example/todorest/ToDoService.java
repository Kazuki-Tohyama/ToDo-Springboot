package com.example.todorest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ToDoService implements ServiceInterface {
	List<Task> taskList = new ArrayList<Task>();
	
	public List<Task> getTaskList() {
		return this.taskList;
	}

	public void add(Task item) {
		taskList.add(item);
	}

	public void delete(int id) {
		taskList.remove(id);		
	}

}