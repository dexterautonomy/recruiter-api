package com.recruiter.devops.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recruiter.devops.dto.UserDTO;
import com.recruiter.devops.serviceImpl.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user/v1")
@CrossOrigin(maxAge = 3600, origins = "*")
public class UserController {

	private final UserServiceImpl userServiceImpl;
	
	public List<UserDTO> fetchUser(){
		return userServiceImpl.fetUsers().get();
	}
}
