package com.example.todorest.todo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements UserRepositoryInterface {
	
	private final JdbcTemplate template;
	
	@Autowired
	public UserRepository(JdbcTemplate template) {
		this.template = template;
	}
	

	@Override
	public LoginUser findUserByUsername(String username) {
		final String query = "SELECT * FROM user where username = ?";
		List<LoginUser> result = template.query(query, new RowMapper<LoginUser>() {
			@Override
			public LoginUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				LoginUser loginUser = new LoginUser(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
				return loginUser;
			}
			
		}, username);
		if (result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}

	@Override
	public void addUser(String username, String password) {
		// TODO Auto-generated method stub
		
	}
	
}