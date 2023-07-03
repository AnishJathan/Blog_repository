package com.anish.blogRepo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anish.blogRepo.payload.UserDTO;
import com.anish.blogRepo.repository.Repository;
import com.anish.blogRepo.services.UserService;
import com.anish.blogRepo.entity.*;
import com.anish.blogRepo.exception.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {
	
	
	private Repository userRepo;
	

	public UserServiceImpl(Repository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public UserDTO createUser(UserDTO userDto) {
		Users user = this.dtoTouser(userDto);
		Users savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDTO updateUser(UserDTO userDto, long userId) {
		
		Users user = this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("Users","id",userId));
		
		user.setfName(userDto.getfName());
		user.setlName(userDto.getlName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setBio(userDto.getBio());
		
		Users updateUser = this.userRepo.save(user);
		UserDTO userDto1 =this.userToDto(updateUser);
		return userDto1;
	}

	@Override
	public UserDTO getUserById(long id) {
		Users user = this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Users","Id", id));
		return this.userToDto(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<Users> users = this.userRepo.findAll();
		
		List<UserDTO> userDtos= users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		
		return userDtos;
	}

	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		Users user =this.userRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Users", "Id", id));
			this.userRepo.delete(user);
		
	}
	
	private Users dtoTouser(UserDTO userDto) {
		Users user = new Users();
		user.setId(userDto.getId());
		user.setfName(userDto.getfName());
		user.setlName(userDto.getlName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setBio(userDto.getBio());
		
		return user;
	}
	
	private UserDTO userToDto(Users user) {
		UserDTO userDto = new UserDTO();
		userDto.setId(user.getId());
		userDto.setfName(user.getfName());
		userDto.setlName(user.getlName());	
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setBio(user.getBio());
		
		return userDto;
	}

}
