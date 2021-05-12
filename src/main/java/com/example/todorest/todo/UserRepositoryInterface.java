package com.example.todorest.todo;

public interface UserRepositoryInterface {
	LoginUser findUserByUsername(String username);
	void addUser(String username, String password);
}