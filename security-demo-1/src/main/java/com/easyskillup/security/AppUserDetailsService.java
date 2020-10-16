package com.easyskillup.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.easyskillup.model.AppUserDetails;
import com.easyskillup.model.User;
import com.easyskillup.repos.UserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepo.findByUserName(username);
		user.orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));
		return user.map(AppUserDetails::new).get();
	}
}
