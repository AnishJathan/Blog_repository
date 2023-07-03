package com.anish.blogRepo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anish.blogRepo.entity.Users;
import com.anish.blogRepo.services.UserService;

public interface Repository extends JpaRepository<Users, Long>{

}
