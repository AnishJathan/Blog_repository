package com.anish.blogRepo.payload;

import com.anish.blogRepo.entity.Users;

public class CommentDTO {
	
	private long comment_id;
	private String content;
	
	private Users user;
	
	
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public long getComment_id() {
		return comment_id;
	}
	public void setComment_id(long comment_id) {
		this.comment_id = comment_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
