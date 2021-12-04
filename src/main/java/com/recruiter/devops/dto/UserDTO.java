package com.recruiter.devops.dto;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
	private String id;
	@NotBlank
	private String name;
	@NotBlank
	private String username;
	@NotBlank
	private String phonenumber;
	@Email
	@Pattern(regexp=".+@.+\\..+")
	private String email;
	@Valid
	@NotNull
	private AddressDTO address;
}
