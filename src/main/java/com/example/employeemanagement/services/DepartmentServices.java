package com.example.employeemanagement.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemanagement.dto.DepartmentDTO;
import com.example.employeemanagement.model.Department;
import com.example.employeemanagement.repository.DepartmentRepository;

@Service
public class DepartmentServices implements IDepartmentServices{
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public DepartmentDTO getDepartmentById(Integer departmentId) {
		Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
	    Department department=optionalDepartment.get();
	    DepartmentDTO departmentDTO = new DepartmentDTO();
	    departmentDTO.setId(department.getId());
		departmentDTO.setDepartmentName(department.getDepartmentName());
		departmentDTO.setCity(department.getCity());
	    return departmentDTO;
	}

}
