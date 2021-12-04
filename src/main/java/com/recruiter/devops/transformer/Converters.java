package com.recruiter.devops.transformer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.recruiter.devops.dto.AddressDTO;
import com.recruiter.devops.dto.UserDTO;
import com.recruiter.devops.model.Address;
import com.recruiter.devops.model.User;

@Component
public class Converters {
	
	public List<UserDTO> fetUserDTO(List<User> users){
		return users.stream().map(this::convertUser_UserDTO).collect(Collectors.toList());
	}
	
	public User convertUserDTO_User(UserDTO userDTO) {
		User user = new User();
		user.setEmail(userDTO.getEmail());
		user.setName(userDTO.getName());
		user.setPhonenumber(userDTO.getPhonenumber());
		user.setUsername(userDTO.getUsername());
		user.setAddress(convertAddressDTO_Address(userDTO.getAddress()));
		
		return user;
	}
	
	public Address convertAddressDTO_Address(AddressDTO addressDTO) {
		Address address = new Address();
		address.setCity(addressDTO.getCity());
		address.setStreet(addressDTO.getStreet());
		address.setZipcode(addressDTO.getZipcode());
		
		return address;
	}

	public UserDTO convertUser_UserDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId().toString());
		userDTO.setEmail(user.getEmail());
		userDTO.setName(user.getName());
		userDTO.setPhonenumber(user.getPhonenumber());
		userDTO.setUsername(user.getUsername());
		userDTO.setAddress(convertAddress_AddressDTO(user.getAddress()));
		
		return userDTO;
	}
	
	public AddressDTO convertAddress_AddressDTO(Address address) {
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setCity(address.getCity());
		addressDTO.setStreet(address.getStreet());
		addressDTO.setZipcode(address.getZipcode());
		
		return addressDTO;
	}
}
