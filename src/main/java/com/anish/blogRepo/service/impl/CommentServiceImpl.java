 package com.anish.blogRepo.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anish.blogRepo.entity.Comment;
import com.anish.blogRepo.entity.Post;
import com.anish.blogRepo.entity.Users;
import com.anish.blogRepo.exception.ResourceNotFoundException;
import com.anish.blogRepo.payload.CommentDTO;
import com.anish.blogRepo.repository.CommentRepository;
import com.anish.blogRepo.repository.PostRepository;
import com.anish.blogRepo.repository.Repository;
import com.anish.blogRepo.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	private CommentRepository commentRepo;
	
	public CommentServiceImpl(CommentRepository commentRepo) {
		super();
		this.commentRepo = commentRepo;
	}
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private Repository userRepo;
	@Autowired
	private ModelMapper modelMapper; 

	@Override
	public CommentDTO createComment(CommentDTO commentDto, long post_id , long user_id) {
		Post post = this.postRepo.findById(post_id).orElseThrow(()->new ResourceNotFoundException("Post","post_id", post_id));
		Users user = this.userRepo.findById(user_id).orElseThrow(()-> new ResourceNotFoundException("User", "user_id", user_id));
		Comment comments = this.modelMapper.map(commentDto, Comment.class);
		
		comments.setPost(post);
		comments.setUser(user);
		Comment newComment = this.commentRepo.save(comments);
		
		return this.modelMapper.map(newComment, CommentDTO.class);
	}

	@Override
	public void deleteComment(long commnet_id) {
		
		Comment comments = this.commentRepo.findById(commnet_id).orElseThrow(()-> new ResourceNotFoundException("comment", "comment_id", commnet_id));
		
		this.commentRepo.delete(comments);
	}

}
