package com.example.employeemanagement.dto;

import java.util.Set;

public class DepartmentDTO {
	private Integer id;

	private String departmentName;
	
	private String city;


	public DepartmentDTO() {
		// TODO Auto-generated constructor stub
	}

	public DepartmentDTO(Integer id, String departmentName, String city, Set<EmployeeDTO> employees) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.city = city;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "DepartmentDTO [id=" + id + ", departmentName=" + departmentName + ", city=" + city + "]";
	}
	
    
}
