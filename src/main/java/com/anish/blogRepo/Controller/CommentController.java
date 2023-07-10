package com.anish.blogRepo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anish.blogRepo.entity.Comment;
import com.anish.blogRepo.payload.CommentDTO;
import com.anish.blogRepo.repository.CommentRepository;
import com.anish.blogRepo.services.CommentService;

@RestController
@RequestMapping("/api")
public class CommentController {
	
	private CommentService commentService;
	
	
	
	public CommentController(CommentService commentService) {
		super();
		this.commentService = commentService;
	}



	@PostMapping("/user/{user_id}/post/{post_id}/comment")
	public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentDto ,
			@PathVariable long user_id,
			@PathVariable long post_id
			){
		CommentDTO createComment= this.commentService.createComment(commentDto, post_id, user_id);
		
		return new ResponseEntity<CommentDTO>(createComment , HttpStatus.CREATED);
		
	}
	
	
}
