package com.cts.userservice.service;

import com.cts.userservice.entity.Authorities;
import com.cts.userservice.repository.AuthorityRepoImp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.cts.userservice.entity.UserEntity;
import com.cts.userservice.model.UserModel;
import com.cts.userservice.repository.UserRepository;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service

public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository user;

	@Autowired
	AuthorityRepoImp authorityRepo;
	

	ModelMapper modelMapper = new ModelMapper();
		
	
	@Override
	public UserModel validateUser(UserModel userModel) {
	
		UserEntity userEntity = user.findByUserName(userModel.getUserName());

		
		userModel.setUserId(userEntity.getUserId());
		userModel.setUserName(userEntity.getUserName());
		userModel.setUserPassword("");
		userModel.setUserMobile(userEntity.getUserMobile());
		userModel.setUserRole(userEntity.getUserRole());
		
		return userModel;
		}

	@Override
	public UserModel addUser(UserModel userModel) {
		UserEntity userEntity=new UserEntity();
		userEntity.setUserPassword("{noop}" +userModel.getUserPassword());
		userEntity.setUserName(userModel.getUserName());
		userEntity.setUserMobile(userModel.getUserMobile());
		userEntity.setEnabled(true);
		userEntity = user.save(userEntity);
		Authorities role = new Authorities(userEntity.getUserName(),"ROLE_USER");
		authorityRepo.save(role);
		return userModel;
	}

	@Override
	public Integer getUserId(String user) {
		UserEntity userEntity  = this.user.findByUserName(user);
		if(userEntity != null)
		{
			return userEntity.getUserId();
		}
		return -1;
	}

}
