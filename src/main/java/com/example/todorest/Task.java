package com.example.todorest;

public class Task {
	private int id;
	private String taskName;
	private boolean isDone;
	
	public Task(String taskName, boolean isDone) {
		this.taskName = taskName;
		this.isDone = isDone;
	}
	
	public Task() {
		this.taskName = "";
		this.isDone = false;
	}

	public String getTaskName() {
		return this.taskName;
	}
	
	public int getId() {
		return this.id;
	}
	
	public boolean isDone() {
		return this.isDone;
	}
	
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setIsDone(boolean isDone) {
		this.isDone = isDone;
	}
}