package com.anish.blogRepo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.anish.blogRepo.entity.Users;
import com.anish.blogRepo.exception.ResourceNotFoundException;
import com.anish.blogRepo.repository.Repository;

@Service
public class CustomUseruserDetailsService implements UserDetailsService {
	@Autowired
	private Repository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users userInfo = userRepo.findByEmail(username).
				orElseThrow(()-> new ResourceNotFoundException("user", "username"+username, 0));
		return userInfo; 
	}
 
}
