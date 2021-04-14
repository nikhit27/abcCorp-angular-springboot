package com.cts.userservice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserModel {
	
	private Integer userId;
	private String userName;
	private String userPassword;
	private String userMobile;
	private String userRole;
	
}
