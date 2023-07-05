package com.anish.blogRepo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Users {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="first_name")
	private String fName;
	@Column(name="last_name")
	private String lName;
	private String email;
	private String password;
	private String bio;
	public Users(String fName, String lName, String email, String password, String bio) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.bio = bio;
	}
	
	public Users() {
		
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
