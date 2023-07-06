package com.anish.blogRepo.services;

import java.util.List;

import com.anish.blogRepo.entity.Category;
import com.anish.blogRepo.entity.Post;
import com.anish.blogRepo.entity.Users;
import com.anish.blogRepo.payload.PostDTO;

public interface PostService {
	
	//Create 
	PostDTO createPost(PostDTO postDto, Long user_id , Long category_id);
	
	//update
	
	Post updatePost(PostDTO postDto, long post_id);
	
	//delete
	
	void deletePost(long post_id);
	
	//get all post
	List<Post> getAllPost();
	
	
	//get post by id
	
	Post getPostById(long post_id);
	
	//get post by category
	List<PostDTO> getPostByCategory(long Category_id);
	
	// get post by user id
	List<PostDTO> getPostByUser(long user_id);
	
	//Get post by Search
	List<Post> searchPost(String keyword);
	

}