package com.example.employeemanagement.dto;

import com.example.employeemanagement.model.Role;

public class AuthenticatedUserDTO {
	private String name; 
	
	private String userName;

	private String password;

	private Role userRole;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "AuthenticatedUserDTO [name=" + name + ", userName=" + userName + ", password=" + password
				+ ", userRole=" + userRole + "]";
	}
	
	
	
	
}
