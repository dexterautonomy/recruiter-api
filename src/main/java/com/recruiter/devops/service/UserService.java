package com.recruiter.devops.service;

import java.util.List;
import java.util.Optional;

import com.recruiter.devops.dto.UserDTO;

public interface UserService {
	Optional<List<UserDTO>> fetUsers();
}