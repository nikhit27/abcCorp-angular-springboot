package com.cts.userservice.controller;


import javax.servlet.http.HttpServletRequest;
import com.cts.userservice.model.UserModel;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

public interface IUserController {

    public String testConfigServer();


    public  ResponseEntity<UserModel> loginUser(HttpServletRequest request);
}
