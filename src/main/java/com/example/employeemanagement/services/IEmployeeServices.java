package com.example.employeemanagement.services;

import java.util.List;

import com.example.employeemanagement.dto.EmployeeDTO;

public interface IEmployeeServices {
	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
	public EmployeeDTO getEmployeeById(Integer employeeId);
	public EmployeeDTO updateEmployee(Integer employeeId,EmployeeDTO employeeDTO);
	public String deleteEmployee(Integer employeeId);
	public List<EmployeeDTO> getEmployeeByFirstAndLastName(String firstName,String lastName);
	public List<EmployeeDTO> getAllEmployees();
}
