package com.recruiter.devops.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;

import com.recruiter.devops.dto.UserDTO;
import com.recruiter.devops.model.User;
import com.recruiter.devops.repository.UserRepository;
import com.recruiter.devops.service.UserService;
import com.recruiter.devops.transformer.Converters;
import com.recruiter.devops.utilities.ApiCalls;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private ApiCalls apiCalls;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private Converters userConverter;

	@Override
	public Optional<List<UserDTO>> fetUsers() {
		List<UserDTO> userDTOs = null;
		
		try {
			List<User> users = userRepo.findAll();
			
			if(users.isEmpty()) {
				userDTOs = apiCalls.fetchExternalUsers();
			}
			else {
				userDTOs = userConverter.fetUserDTO(users);
			}
		}
		catch(DataAccessResourceFailureException e) {
			userDTOs = apiCalls.fetchExternalUsers();
		}

		return Optional.of(userDTOs);
	}
}