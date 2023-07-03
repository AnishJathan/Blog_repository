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
@NoArgsConstructor
@Getter
@Setter
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
}
