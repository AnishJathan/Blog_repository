package com.anish.blogRepo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anish.blogRepo.entity.Category;
import com.anish.blogRepo.exception.ResourceNotFoundException;
import com.anish.blogRepo.payload.CategoryDTO;
import com.anish.blogRepo.repository.CategoryRepostory;
import com.anish.blogRepo.services.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService {
	
	private CategoryRepostory catRepo;
	
	public CategoryServiceImp(CategoryRepostory catRepo) {
		super();
		this.catRepo = catRepo;
	}
	@Autowired
	private ModelMapper	 modelMapper;

	@Override
	public CategoryDTO createCategory(CategoryDTO catDto) {
		Category cat= this.modelMapper.map(catDto, Category.class);
		Category addedCat= this.catRepo.save(cat);
		return this.modelMapper.map(addedCat, CategoryDTO.class);
	}
 
	@Override
	public CategoryDTO updateCategory(CategoryDTO caDto, long id) {
		Category cat = this.catRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "Category id", id));
		cat.setCategoryTitle(caDto.getCategoryTitle());
		cat.setCategoryDescription(caDto.getCategoryDescription());
		
		Category updateCat = this.catRepo.save(cat);
		
		return this.modelMapper.map(updateCat, CategoryDTO.class );
	}

	@Override
	public void deleteCategory(long id) {
		// TODO Auto-generated method stub
		Category cat = this.catRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "id", id));
		
		this.catRepo.delete(cat);
	}

	@Override
	public List<CategoryDTO> getAllCategory() {
		List<Category> category = this.catRepo.findAll();
		List<CategoryDTO> catDto= category.stream().map((cat)-> this.modelMapper.map(cat, CategoryDTO.class)).collect(Collectors.toList());
		return catDto;
	}

	@Override
	public CategoryDTO getCategoryById(long id) {
		// TODO Auto-generated method stub
		Category catDto = this.catRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "id", id));
		
		return this.modelMapper.map(catDto, CategoryDTO.class) ;
	}

}
