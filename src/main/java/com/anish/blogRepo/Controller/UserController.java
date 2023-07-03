package com.anish.blogRepo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.anish.blogRepo.payload.UserDTO;
import com.anish.blogRepo.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private UserService userService;
	


	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}


	//Post - create user
	@PostMapping("/create")	
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDto){
		UserDTO createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}
		//Put-update user
	
		//Delete delete user
	
		//Get - user get
}
