package com.recruiter.devops.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class User {
	@Id
	private UUID id;
	private String name;
	private String username;
	private String phonenumber;
	private String email;
	
	private Address address;
}
