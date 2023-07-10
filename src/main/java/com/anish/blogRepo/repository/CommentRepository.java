package com.anish.blogRepo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anish.blogRepo.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
