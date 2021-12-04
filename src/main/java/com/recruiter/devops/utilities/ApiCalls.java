package com.recruiter.devops.utilities;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.recruiter.devops.config.AppProperties;
import com.recruiter.devops.model.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ApiCalls {
	private final AppProperties props;
	private final RestTemplate restTemplate;
	
	public List<User> fetchExternalUsers() {
		try {
			String response = restTemplate.getForObject(props.getExternal(), String.class);
			log.info("---->>> {}", response);
			
			List<User> users = JsonBuilder.toClassTypeReference(response, new TypeReference<List<User>>() {});
			
			return users;
		}
		catch (RestClientException e) {
			log.error("---->>> Error: " + e);
		}
		
		return null;
	}
}
