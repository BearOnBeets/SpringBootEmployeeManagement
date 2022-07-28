package com.example.employeemanagement.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemanagement.dto.AuthenticatedUserDTO;
import com.example.employeemanagement.dto.UserDTO;
import com.example.employeemanagement.exceptions.NoSuchRoleException;
import com.example.employeemanagement.model.Role;
import com.example.employeemanagement.model.User;
import com.example.employeemanagement.repository.RoleRepository;
import com.example.employeemanagement.repository.UserRepository;



@Service
public class UserServices implements IUserServices {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	public UserDTO getUserByID(Integer userId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		User user=optionalUser.get();
		UserDTO userDTO=new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setUserName(user.getUserName());
		userDTO.setPassword(user.getPassword());
		userDTO.setName(user.getName());
		userDTO.setUserRole(user.getUserRole().getId());
		return userDTO;
	}

	
	public UserDTO saveUser(UserDTO userDTO) {
		User user=new User();
		user.setUserName(userDTO.getUserName());
		user.setPassword(userDTO.getPassword());
		user.setName(userDTO.getName());
		Optional<Role> optionalRole = roleRepository.findById(userDTO.getUserRole());
		if(optionalRole.isEmpty()) throw new NoSuchRoleException();
		Role role=optionalRole.get();
		user.setUserRole(role);
		User userFromDB = userRepository.save(user);
		UserDTO userResponseDTO = getUserByID(userFromDB.getId());
		return userResponseDTO;
	}
	
	public UserDTO authenticateUser(UserDTO userDTO) {
		User user=userRepository.findByUserNameAndPassword(userDTO.getUserName(),userDTO.getPassword()); //exception
		UserDTO userResponseDTO=new UserDTO();
		userResponseDTO.setId(user.getId());
		userResponseDTO.setUserName(user.getUserName());
		userResponseDTO.setPassword(user.getPassword());
		return userResponseDTO;
	}



	public AuthenticatedUserDTO findAuthenticatedUserByUsername(String username) {
		User user = userRepository.findByUserName(username);
		AuthenticatedUserDTO authenticatedUserDTO  = new AuthenticatedUserDTO();
		authenticatedUserDTO.setName(username);
		authenticatedUserDTO.setUserName(user.getUserName());
		authenticatedUserDTO.setUserRole(user.getUserRole());
		authenticatedUserDTO.setPassword(user.getPassword());
		return authenticatedUserDTO;
	}
	
	


	

	

	
}
