package com.anish.blogRepo.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDTO {
	
	private long id;
	
	@NotNull
	@Size(min=4 , message = "name should be min of 4 character")
	private String fName;
	@NotNull
	private String lName;
	@NotNull(message = "Email not valid")
	private String email;
	
	@NotNull
	@Size(min=5 , message = "enter valid password")
	private String password;
	@NotEmpty
	private String bio;
	
	public UserDTO() {
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	
}
