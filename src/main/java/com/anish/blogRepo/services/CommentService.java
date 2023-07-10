package com.anish.blogRepo.services;

import com.anish.blogRepo.payload.CommentDTO;
import com.anish.blogRepo.payload.PostDTO;

public interface CommentService {
	
	CommentDTO createComment(CommentDTO comment,long post_id , long user_id);
	
	void deleteComment(long commnet_id);
}
