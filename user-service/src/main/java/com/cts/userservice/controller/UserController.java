package com.cts.userservice.controller;


import java.util.Base64;
import java.nio.charset.StandardCharsets;
import javax.servlet.http.HttpServletRequest;

import com.cts.userservice.Exceptions.UserErrorResponse;
import com.cts.userservice.model.UserModel;
import com.cts.userservice.service.UserServiceImpl;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private Environment env;

    @Autowired
    private UserServiceImpl userService;
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    
    
    @GetMapping("/testServer")
    public String testConfigServer()
    {	
        return env.getProperty("msg","Config success");  
    }
    

    @GetMapping("/login")
    public  ResponseEntity<UserModel> loginUser(HttpServletRequest request) {
    	String authorization = request.getHeader("Authorization");
		String[] values = null;
		
		if (authorization != null && authorization.startsWith("Basic")) {
		    // Authorization: Basic base64credentials
		    String base64Credentials = authorization.substring("Basic".length()).trim();
		    byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
		    String credentials = new String(credDecoded, StandardCharsets.UTF_8);
		    // credentials = username:password
		    values = credentials.split(":", 2);
		}
    	
		
		logger.info("Logged In...");
		System.out.println(values[0] + "  : username");
		System.out.println(values[0] + "  : username");
		System.out.println(values[0] + "  : username");
		System.out.println(values[0] + "  : username");
		System.out.println(values[0] + "  : username");
		System.out.println(values[0] + "  : username");
		
        UserModel temp = new UserModel();
        temp.setUserName(values[0]);
        
        UserModel user = this.userService.validateUser(temp);
    	
        return new ResponseEntity<UserModel>(user,HttpStatus.OK);
    }

    	
    @GetMapping("/getUserId")
    public  ResponseEntity<Integer> getUserId(@RequestHeader HttpHeaders headers)
    {
        String user= headers.get("user-name").get(0);
        logger.info("user id is " + user);
        Integer id = this.userService.getUserId(user);
        return new ResponseEntity<>(id,HttpStatus.OK);
    }
   
    @ExceptionHandler  // ~catch
	public ResponseEntity<UserErrorResponse> productOperationErrorHAndler(Exception ex) {
		// create error object
		UserErrorResponse error = new UserErrorResponse(ex.getMessage(), 
															  HttpStatus.BAD_REQUEST.value(), 
															  System.currentTimeMillis());
		ResponseEntity<UserErrorResponse> response =
										new ResponseEntity<UserErrorResponse>(error, HttpStatus.NOT_FOUND);
		logger.error("Exception :" + error);
		
		return response;
	}
	

}
