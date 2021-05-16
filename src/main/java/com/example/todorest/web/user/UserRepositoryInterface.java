package com.example.todorest.web.user;

public interface UserRepositoryInterface {
	LoginUser findUserByUsername(String username);
	void addUser(String username, String password);
}