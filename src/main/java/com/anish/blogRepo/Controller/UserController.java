package com.anish.blogRepo.Controller;

import java.util.List;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.anish.blogRepo.payload.ApiResponse;
import com.anish.blogRepo.payload.UserDTO;
import com.anish.blogRepo.services.UserService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

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
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDto){
		UserDTO createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}
	//Put-update user
	@PutMapping("/create/{id}")
	public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody  UserDTO userDto , @PathVariable long id){
			 	UserDTO updateuser =  this.userService.updateUser(userDto, id);
			 	return  ResponseEntity.ok(updateuser);
		}
		
	//Delete delete user
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable long id ){
			this.userService.deleteUser(id);
			return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully",true), HttpStatus.OK);
		}
	
	//Get - user get
	@GetMapping("/")
	public ResponseEntity<List<UserDTO>> getAllUser(){
			return ResponseEntity.ok(this.userService.getAllUsers());
		}
		
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getSingleUser(@PathVariable long id){
		return ResponseEntity.ok(this.userService.getUserById(id));
	}
}
