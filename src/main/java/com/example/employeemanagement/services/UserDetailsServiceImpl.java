package com.example.employeemanagement.services;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.employeemanagement.dto.AuthenticatedUserDTO;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserServices userServices;
	
	public UserDetails loadUserByUsername(String username) {
		final AuthenticatedUserDTO authenticatedUserDTO = userServices.findAuthenticatedUserByUsername(username);
		final String authenticatedUserName = authenticatedUserDTO.getUserName();
		final String authenticatedPassword = authenticatedUserDTO.getPassword();
		final SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authenticatedUserDTO.getUserRole());		
		return new User(authenticatedUserName, authenticatedPassword, Collections.singletonList(grantedAuthority));
	
	}

}
