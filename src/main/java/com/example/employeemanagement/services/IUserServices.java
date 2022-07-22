package com.example.employeemanagement.services;

import com.example.employeemanagement.dto.AuthenticatedUserDTO;
import com.example.employeemanagement.dto.UserDTO;
import com.example.employeemanagement.model.User;

public interface IUserServices {
	public UserDTO getUserByID(Integer userId);
	public UserDTO saveUser(UserDTO userDTO);
	public UserDTO authenticateUser(UserDTO userDTO);
//	public User loadUserByUsername(String username);
	public AuthenticatedUserDTO findAuthenticatedUserByUsername(String username);

}
