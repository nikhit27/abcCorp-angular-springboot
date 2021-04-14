package com.cts.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.userservice.entity.UserEntity;



public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
    UserEntity findByUserName(String userName);

	UserEntity findByUserNameAndUserPassword(String userName, String userPassword);
	
}
