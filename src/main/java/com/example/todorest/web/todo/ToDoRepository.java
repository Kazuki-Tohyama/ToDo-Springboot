package com.example.todorest.web.todo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import com.example.todorest.web.user.LoginUser;

@Repository
public class ToDoRepository implements RepositoryInterface {
	
	private final JdbcTemplate template;
	
	@Autowired
	public ToDoRepository(JdbcTemplate template) {
		this.template = template;
	}
	

	@Override
	public List<Task> findAll() {
		int userId = getUserId();
		
		final String query = "SELECT * FROM todo where userid = ?";
		List<Task> allTaskList = template.query(query, new RowMapper<Task>() {
			@Override
			public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
				Task task = new Task();
				task.setId(rs.getInt("id"));
				task.setTaskName(rs.getString("name"));
				task.setIsDone(rs.getBoolean("isdone"));
				task.setUserId(rs.getInt("userid"));
				return task;
			}
		}, userId);
		return allTaskList;
	}

	@Override
	public void addItem(Task item) {
		String name = item.getTaskName();
		boolean isdone = item.isDone();
		int userId = getUserId();
		final String query = "INSERT INTO todo(name, isdone, userid) VALUE(?,?,?)";
		template.update(query, name, isdone, userId);
	}

	@Override
	public void deleteItem(int id) {
		final String query = "DELETE FROM todo WHERE id = ?";
		template.update(query, id);
	}
	
	private int getUserId() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		final String query = "SELECT * FROM user where username = ?";
		List<LoginUser> userResult = template.query(query, new RowMapper<LoginUser>() {
			@Override
			public LoginUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				LoginUser user = new LoginUser(id, username, password);
				return user;
			}
		}, username);
		
		return userResult.get(0).getUserId();
	}
}
