package com.anish.blogRepo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anish.blogRepo.payload.UserDTO;


public interface UserService {
	UserDTO createUser(UserDTO user);
	UserDTO updateUser(UserDTO user, long id);
	UserDTO getUserById(long id);
	List<UserDTO> getAllUsers();
	void deleteUser(long id);
}
