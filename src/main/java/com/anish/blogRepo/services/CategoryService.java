package com.anish.blogRepo.services;

import java.util.List;

import com.anish.blogRepo.payload.CategoryDTO;

public interface CategoryService {
	
	//create
	
	CategoryDTO createCategory(CategoryDTO catDto);
	
	//update
	
	CategoryDTO updateCategory(CategoryDTO caDto, long id);
	
	//delete
	void deleteCategory(long id);
	
	//get all category
	List<CategoryDTO> getAllCategory();
	
	//get
	CategoryDTO getCategoryById(long id);
	
	
}
