package com.recruiter.devops.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDTO {
	private String id;
	@NotBlank
	private String city;
	@NotBlank
	private String street;
	@NotBlank
	private String zipcode;
}