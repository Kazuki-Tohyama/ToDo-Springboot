package com.example.todorest.todo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ToDoRepository implements RepositoryInterface {
	
	private final JdbcTemplate template;
	
	@Autowired
	public ToDoRepository(JdbcTemplate template) {
		this.template = template;
	}
	

	@Override
	public List<Task> findAll() {
		final String query = "SELECT * FROM todo";
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
		});
		return allTaskList;
	}

	@Override
	public void addItem(Task item) {
		String name = item.getTaskName();
		boolean isdone = item.isDone();
		int userId = item.getUserId();
		final String query = "INSERT INTO todo(name, isdone, userid) VALUE(?,?,?)";
		template.update(query, name, isdone, userId);
	}

	@Override
	public void deleteItem(int id) {
		final String query = "DELETE FROM todo WHERE id = ?";
		template.update(query, id);
	}
	
}