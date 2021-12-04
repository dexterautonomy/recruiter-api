package com.recruiter.devops.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.recruiter.devops.dto.UserDTO;
import com.recruiter.devops.model.User;
import com.recruiter.devops.repository.UserRepository;
import com.recruiter.devops.service.UserService;
import com.recruiter.devops.transformer.Converters;
import com.recruiter.devops.utilities.ApiCalls;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final ApiCalls apiCalls;
	private final UserRepository userRepo;
	private final Converters userConverter;

	@Override
	public Optional<List<UserDTO>> fetUsers() {
		List<UserDTO> userDTOs = null;
		List<User> users = userRepo.findAll();
		
		if(users.isEmpty()) {
			users = apiCalls.fetchExternalUsers();
		}
		
		userDTOs = userConverter.fetUserDTO(users);
		
		return Optional.of(userDTOs);
	}
}