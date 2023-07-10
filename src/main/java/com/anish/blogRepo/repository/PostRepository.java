package com.anish.blogRepo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anish.blogRepo.entity.Category;
import com.anish.blogRepo.entity.Post;
import com.anish.blogRepo.entity.Users;
import com.anish.blogRepo.payload.PostDTO;

public interface PostRepository extends JpaRepository<Post, Long> {
	
	List<Post> findByCategory(Category category);
	List<Post> findByUsers(Users user);
	
	List<Post> findByTitleContaining(String title);

}
