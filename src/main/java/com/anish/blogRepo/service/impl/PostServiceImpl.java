
package com.anish.blogRepo.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.anish.blogRepo.entity.Category;
import com.anish.blogRepo.entity.Post;
import com.anish.blogRepo.entity.Users;
import com.anish.blogRepo.exception.ResourceNotFoundException;
import com.anish.blogRepo.payload.PostDTO;
import com.anish.blogRepo.payload.PostResponse;
import com.anish.blogRepo.repository.CategoryRepostory;
import com.anish.blogRepo.repository.PostRepository;
import com.anish.blogRepo.repository.Repository;
import com.anish.blogRepo.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	private PostRepository postRepo;
	public PostServiceImpl(PostRepository postRepo) {
		super();
		this.postRepo = postRepo;
	}
	@Autowired
	private ModelMapper modelMapper; 
	@Autowired
	private Repository userRepo;
	
	
	@Autowired
	private CategoryRepostory catRepo;
	

	@Override
	public PostDTO createPost(PostDTO postDto, Long user_id, Long category_id) {
		Users user = this.userRepo.findById(user_id).orElseThrow(()->new ResourceNotFoundException("Users", "user id", user_id));
		Category category = this.catRepo.findById(category_id).orElseThrow(()-> new ResourceNotFoundException("Category", "Category id", category_id));
		
		Post post= this.modelMapper.map(postDto, Post.class);
		
		post.setImageName("default.png");
		post.setAddedDate( new java.util.Date());
		post.setUsers(user);
		post.setCategory(category);
		
		Post newPost= this.postRepo.save(post);
		return this.modelMapper.map(newPost, PostDTO.class) ;
	}

	@Override
	public PostDTO updatePost(PostDTO postDto, long post_id) {
		Post findPost = this.postRepo.findById(post_id).orElseThrow(()-> new ResourceNotFoundException("Post", "post id", post_id));
		
		findPost.setTitle(postDto.getTitle());
		findPost.setContent(postDto.getContent());
		findPost.setImageName(postDto.getImageName());
		
		Post updatedPost = this.postRepo.save(findPost);
		
		return this.modelMapper.map(updatedPost,PostDTO.class);
	}

	@Override
	public void deletePost(long post_id) {
		Post findPost = this.postRepo.findById(post_id).orElseThrow(()-> new ResourceNotFoundException("Post", "Post id", post_id));
		
		this.postRepo.delete(findPost);
		
	}

	@Override
	public PostResponse getAllPost(Integer pageNumber , Integer pageSize,String sortBy, String sortDir) {
		
		Sort sort = (sortDir.equalsIgnoreCase("asc"))?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
		
		
		Pageable p = PageRequest.of(pageNumber, pageSize, sort);
		
		Page<Post> pagePost = this.postRepo.findAll(p);
		
		List<Post> allPosts = pagePost.getContent();
		
		List<PostDTO> postDtos = allPosts.stream().map((post)-> this.modelMapper.map(post,PostDTO.class)).collect(Collectors.toList());
		
		PostResponse postResponse = new PostResponse();
		
		postResponse.setContant(postDtos);
		postResponse.setPageNumber(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setTotalElement(pagePost.getTotalElements());
		postResponse.setTotalPage(pagePost.getTotalPages());
		
		postResponse.setLastPage(pagePost.isLast());
		
		
		return postResponse;
	}

	@Override
	public PostDTO getPostById(long post_id) {
		Post post = this.postRepo.findById(post_id).orElseThrow(()-> new ResourceNotFoundException("post", "post id", post_id));
		
		return this.modelMapper.map(post, PostDTO.class);
	}

	@Override
	public List<PostDTO> getPostByCategory(long Category_id) {
		
		Category cat = this.catRepo.findById(Category_id).orElseThrow(()-> new ResourceNotFoundException("category", "category", Category_id));
		
		List<Post> posts = this.postRepo.findByCategory(cat);
		
		List<PostDTO> postDtos = posts.stream().map((post)-> this.modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
		
		return postDtos;
	}

	@Override
	public List<PostDTO> getPostByUser(long user_id) {
		Users user = this.userRepo.findById(user_id).orElseThrow(()-> new ResourceNotFoundException("user","user id", user_id));
		
		List<Post> posts = this.postRepo.findByUsers(user);
		
		List<PostDTO> postDtos = posts.stream().map((post)-> this.modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
		
		return postDtos;
	}

	@Override
	public List<Post> searchPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	
}