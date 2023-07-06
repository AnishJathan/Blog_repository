package com.anish.blogRepo.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anish.blogRepo.payload.ApiResponse;
import com.anish.blogRepo.payload.CategoryDTO;
import com.anish.blogRepo.services.CategoryService;

@RestController
@RequestMapping("api/category/")
public class CategoryController {
	
	
	CategoryService catService;
	
	public CategoryController(CategoryService catService) {
		super();
		this.catService = catService;
	}

	//Create 
	@PostMapping("/create")
	public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO catDto ){
		CategoryDTO createCatDto = this.catService.createCategory(catDto);
		
		return new  ResponseEntity<>(createCatDto, HttpStatus.CREATED);
	}
	
	//update
	
	@PostMapping("/update/{id}")
	public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO catDto, @PathVariable long id){
		CategoryDTO updateCategory = this.catService.updateCategory(catDto, id);
		return ResponseEntity.ok(updateCategory);
	}
	
	//delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable long id){
		this.catService.deleteCategory(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted successfully",true), HttpStatus.OK);
	}
	
	//get
	@GetMapping("/getCategory")
	public ResponseEntity<List<CategoryDTO>> getAllCategory(){
		return ResponseEntity.ok(this.catService.getAllCategory());
	}
	//getbyid
	@GetMapping("/getCategory/{id}")
	public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable long id){
		return ResponseEntity.ok(this.catService.getCategoryById(id));
	}
}
