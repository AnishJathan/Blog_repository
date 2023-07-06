package com.anish.blogRepo.Controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anish.blogRepo.payload.PostDTO;
import com.anish.blogRepo.services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	
	//create
	@PostMapping("/user/{user_id}/category/{category_id}/posts")
	public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDto , @PathVariable long user_id
			,@PathVariable long category_id
			){
		PostDTO createdPost= this.postService.createPost(postDto, user_id, category_id);
		
		return new ResponseEntity<PostDTO>(createdPost , HttpStatus.CREATED);
		
	}
	
	@GetMapping("/user/{user_id}/posts")
	public ResponseEntity<List<PostDTO>> getPostByUser(@PathVariable long user_id){
		List<PostDTO> posts= this.postService.getPostByUser(user_id);
		
		return new ResponseEntity<List<PostDTO>>(posts,HttpStatus.OK);
	}
	
	@GetMapping("/category/{category_id}/posts")
	public ResponseEntity<List<PostDTO>> getPostByCategory(@PathVariable long category_id){
		List<PostDTO> posts= this.postService.getPostByCategory(category_id);
		
		return new ResponseEntity<List<PostDTO>>(posts,HttpStatus.OK);
	}
	
	
}
