package com.example.employeemanagement.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.employeemanagement.dto.AuthenticatedUserDTO;
import com.example.employeemanagement.dto.LoginRequestDTO;
import com.example.employeemanagement.dto.LoginResponseDTO;
import com.example.employeemanagement.dto.UserDTO;
import com.example.employeemanagement.exceptions.NoSuchRoleException;
import com.example.employeemanagement.model.Role;
import com.example.employeemanagement.repository.RoleRepository;
import com.example.employeemanagement.services.IUserServices;
import com.example.employeemanagement.services.JwtTokenService;
import com.example.employeemanagement.services.UserServices;

@RestController 
@RequestMapping(path="") 
public class UserController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	IUserServices userServices;
	
	@Autowired
	JwtTokenService jwtTokenService;
	
	@Autowired
	private UserDetailsService userDetailsService; // Here it should be UserDetailsService from spring security
	
	@Autowired
	private RoleRepository roleRepository;
	
	@PostMapping(path="/register")
	public @ResponseBody ResponseEntity<AuthenticatedUserDTO> register(@RequestBody UserDTO userDTO) {
		  UserDTO user = userServices.saveUser(userDTO);
		  AuthenticatedUserDTO authenticatedUserDTO = new AuthenticatedUserDTO();
		  authenticatedUserDTO.setUserName(user.getUserName());
		  authenticatedUserDTO.setPassword(user.getPassword());
		  authenticatedUserDTO.setName(user.getName());
		  Optional<Role> optionalRole = roleRepository.findById(user.getUserRole());
		  if(optionalRole.isEmpty()) throw new NoSuchRoleException();
		  Role role=optionalRole.get();
		  authenticatedUserDTO.setUserRole(role);
		  return new ResponseEntity<>(authenticatedUserDTO,HttpStatus.OK);
	  }
	
	@PostMapping(path="/login")
	public @ResponseBody ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
		Authentication authentication = new UsernamePasswordAuthenticationToken(loginRequestDTO.getUserName(),loginRequestDTO.getPassword());
		authenticationManager.authenticate(authentication);
		final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequestDTO.getUserName()); // Here it will return UserDetails not the user
		final String token = jwtTokenService.generateToken(userDetails); // Pass userDetails not user from spring security
		LoginResponseDTO loginResponseDTO=new LoginResponseDTO();
		loginResponseDTO.setToken(token);
		return new ResponseEntity<>(loginResponseDTO, HttpStatus.OK);
	}
	
}
