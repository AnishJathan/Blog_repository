package com.anish.blogRepo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anish.blogRepo.entity.Category;

public interface CategoryRepostory extends JpaRepository<Category, Long> {

}
