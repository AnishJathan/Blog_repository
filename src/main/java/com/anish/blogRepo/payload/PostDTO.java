package com.anish.blogRepo.payload;

import java.util.Date;

import com.anish.blogRepo.entity.Category;
import com.anish.blogRepo.entity.Users;

import jakarta.persistence.ManyToOne;

public class PostDTO {
	
	private long id;
	private String title;
	private String content;
	
	private String imageName;
	private Date addedDate;	
	
	private Category category;
	
	private Users users;
	
	public PostDTO() {
		
	}
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}	
	
	
}
