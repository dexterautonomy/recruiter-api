package com.recruiter.devops.utilities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recruiter.devops.config.AppProperties;
import com.recruiter.devops.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ApiCalls {
	@Autowired
	private AppProperties props;
	@Autowired
	private RestTemplate restTemplate;
	
	public List<UserDTO> fetchExternalUsers() {
		try {
			String response = restTemplate.getForObject(props.getExternal(), String.class);
			log.info("---->>> {}", response);
			
			List<UserDTO> userDTOs = JsonBuilder.toClassTypeReference(response, new TypeReference<List<UserDTO>>() {});
			
			return userDTOs;
		}
		catch (RestClientException e) {
			log.error("---->>> Error: " + e);
			
			return null;
		}
	}
}
