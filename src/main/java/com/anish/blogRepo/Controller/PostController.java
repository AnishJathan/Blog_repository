package com.anish.blogRepo.Controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anish.blogRepo.config.AppContant;
import com.anish.blogRepo.entity.Post;
import com.anish.blogRepo.payload.ApiResponse;
import com.anish.blogRepo.payload.PostDTO;
import com.anish.blogRepo.payload.PostResponse;
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
	
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPost(
			@RequestParam (value="pageNumber" ,defaultValue =AppContant.PAGE_NUMBER , required = false)Integer pageNumber ,		
			@RequestParam(value = "pageSize", defaultValue = AppContant.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy" , defaultValue = AppContant.sortBy , required = false)String sort,
			@RequestParam(value = "sortDir", defaultValue = AppContant.sortDir, required = false) String sortDir
			){
		PostResponse postResponse = this.postService.getAllPost(pageNumber,pageSize,sort,sortDir);
		
		return new ResponseEntity<PostResponse>(postResponse ,HttpStatus.OK);
	}
	
	@GetMapping("posts/{post_id}")
	public ResponseEntity<PostDTO> getPostbyId(@PathVariable long post_id){
		PostDTO post = this.postService.getPostById(post_id);
		
		return new ResponseEntity<PostDTO>(post,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/posts/{post_id}")
	public ApiResponse deletePost(@PathVariable long post_id) {
		this.postService.deletePost(post_id);
		return new ApiResponse("Post is sucessfully deleted",true);
	}
	
	@PutMapping("/update/posts/{post_id}")
	public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDto , @PathVariable long post_id){
		
		PostDTO updatePost = this.postService.updatePost(postDto, post_id);
		
		return new ResponseEntity<PostDTO>(updatePost, HttpStatus.OK);
	}
	
	@GetMapping("/posts/search/{keyword}")
	public ResponseEntity<List<PostDTO>> search(
			@PathVariable("keyword") String keyword
			){
		List<PostDTO> search = this.postService.searchPost(keyword);
		
		return new ResponseEntity<List<PostDTO>>(search , HttpStatus.OK);
	}
			
}
