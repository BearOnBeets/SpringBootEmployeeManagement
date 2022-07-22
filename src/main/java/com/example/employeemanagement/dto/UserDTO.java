package com.example.employeemanagement.dto;

public class UserDTO {
	private Integer id;
	private String name;
	private String userName;
	private String password;
	private String userRole;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public UserDTO(Integer id, String userName, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", userName=" + userName + ", password=" + password + ", userRole="
				+ userRole + "]";
	}


	
	
	
}
