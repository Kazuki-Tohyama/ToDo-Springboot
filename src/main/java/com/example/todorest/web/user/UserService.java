package com.example.todorest.web.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
	
	private UserRepositoryInterface repository;
	
	@Autowired
	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginUser user = repository.findUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User " +  username + "was not found in the database");
		}
		
		// 権限情報を設定
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		GrantedAuthority authority = new SimpleGrantedAuthority("USER");
		grantList.add(authority);
		
		// パスワードを暗号化
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		UserDetails userDetails = (UserDetails) new User(user.getUserName(), encoder.encode(user.getPassword()), grantList);
		
		return userDetails;
	}
	
}