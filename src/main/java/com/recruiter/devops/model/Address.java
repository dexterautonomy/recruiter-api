package com.recruiter.devops.model;

import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Address {
	private UUID id;
	private String city;
	private String street;
	private String zipcode;
}