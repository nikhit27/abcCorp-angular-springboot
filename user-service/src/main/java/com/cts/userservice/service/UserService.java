package com.cts.userservice.service;

import com.cts.userservice.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
	
	UserModel validateUser(UserModel userModel);
	
	UserModel addUser(UserModel userModel);

    Integer getUserId(String user);
}
