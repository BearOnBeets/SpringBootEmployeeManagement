package com.example.employeemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.employeemanagement.dto.AuthenticatedUserDTO;
import com.example.employeemanagement.dto.LoginRequestDTO;
import com.example.employeemanagement.dto.LoginResponseDTO;
import com.example.employeemanagement.dto.UserDTO;

import com.example.employeemanagement.services.JwtTokenService;
import com.example.employeemanagement.services.UserServices;

@RestController 
@RequestMapping(path="user") 

public class UserController {
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	UserServices userServices;
	
	@Autowired
	JwtTokenService jwtTokenService;
	
	@Autowired
	UserDetails userDetailsServices;
	
	@PostMapping(path="/register")
	public @ResponseBody ResponseEntity<AuthenticatedUserDTO> register(@RequestBody UserDTO userDTO) {
		  UserDTO user = userServices.saveUser(userDTO);
		  AuthenticatedUserDTO authenticatedUserDTO = new AuthenticatedUserDTO();
		  authenticatedUserDTO.setUserName(user.getUserName());
		  authenticatedUserDTO.setPassword(user.getPassword());
		  authenticatedUserDTO.setName(user.getName());
		  authenticatedUserDTO.setUserRole(user.getUserRole());
		  
		  return new ResponseEntity<>(authenticatedUserDTO,HttpStatus.OK);
	  }
	
	@PostMapping(path="/login")
	public @ResponseBody ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
Authentication authentication = new UsernamePasswordAuthenticationToken(loginRequestDTO.getUserName(),loginRequestDTO.getPassword());
	authenticationManager.authenticate(authentication);
//	final User user = userDetailsServices.loadUserByUsername(loginRequestDTO.getUserName());
//	final String token = jwtTokenService.generateToken(user);
	LoginResponseDTO loginResponseDTO=new LoginResponseDTO();
//	loginResponseDTO.setToken(token);
	return new ResponseEntity<>(loginResponseDTO, HttpStatus.OK);
	}
	
}
