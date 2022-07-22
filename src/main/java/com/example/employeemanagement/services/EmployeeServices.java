package com.example.employeemanagement.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.employeemanagement.dto.AddressDTO;
import com.example.employeemanagement.dto.DepartmentDTO;
import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.model.*;
import com.example.employeemanagement.repository.*;

@Service
public class EmployeeServices implements IEmployeeServices {
	
	
	@Autowired 
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AddressServices addressServices;
	
	@Autowired 
	private AddressRepository addressRepository;
	
	@Autowired
	private  DepartmentServices departmentServices;
	
	@Autowired
	private DepartmentRepository departmentRepository;
		

	
	public EmployeeDTO getEmployeeById(Integer employeeId) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
		Employee employee=optionalEmployee.get();
		EmployeeDTO employeeDTO=new EmployeeDTO();
		employeeDTO.setId(employee.getId());
		employeeDTO.setFirstName(employee.getFirstName());
		employeeDTO.setLastName(employee.getLastName());
		employeeDTO.setSalary(employee.getSalary());
		AddressDTO addressDTO = addressServices.getAddressById(employee.getAddress().getId());
		employeeDTO.setAddress(addressDTO);
		DepartmentDTO departmentDTO=departmentServices.getDepartmentById(employee.getDepartment().getId());
		employeeDTO.setDepartment(departmentDTO);
		return employeeDTO;  //Add exceptions
	}
	
	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO){
		 Employee employee = new Employee();  
		 employee.setFirstName(employeeDTO.getFirstName());
		 employee.setLastName(employeeDTO.getLastName());
		 employee.setSalary(employeeDTO.getSalary());
		 
		 AddressDTO addressDTO =  addressServices.saveAddress(employeeDTO.getAddress());
		 Optional<Address> optionalAddress = addressRepository.findById(addressDTO.getId());
		 Address address=optionalAddress.get();
		 employee.setAddress(address);
		 
		 DepartmentDTO departmentDTO=departmentServices.getDepartmentById(employeeDTO.getDepartment().getId());
		 Optional<Department> optionalDepartment = departmentRepository.findById(departmentDTO.getId());
		 Department department=optionalDepartment.get();
		 employee.setDepartment(department);
		 
		Employee employeeFromDB = employeeRepository.save(employee);
		EmployeeDTO employeeResponseDTO=getEmployeeById(employeeFromDB.getId());
		return employeeResponseDTO;  //Add exceptions
	 
	}
	
//	public Integer getEmployeeAddressId(Integer employeeId) {
//		Employee employee=getEmployeeById(employeeId);
//		Integer addressId=employee.getAddress().getId();
//		return addressId;
//		
//	}
	
	public EmployeeDTO updateEmployee(Integer employeeId,EmployeeDTO employeeDTO)
	{
		Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
		Employee employee=optionalEmployee.get();
		employee.setFirstName(employeeDTO.getFirstName());
		employee.setLastName(employeeDTO.getLastName());
		employee.setSalary(employeeDTO.getSalary());
			
		AddressDTO updatedAddressDTO = addressServices.updateAddress(employee.getAddress().getId(),employeeDTO.getAddress());
		Optional<Address> optionalAddress = addressRepository.findById(updatedAddressDTO.getId());
		Address address=optionalAddress.get();
		employee.setAddress(address);
		
		DepartmentDTO departmentDTO=departmentServices.getDepartmentById(employeeDTO.getDepartment().getId());
		Optional<Department> optionalDepartment = departmentRepository.findById(departmentDTO.getId());
		Department department=optionalDepartment.get();
		employee.setDepartment(department);

		Employee employeeFromDB = employeeRepository.save(employee);
		EmployeeDTO employeeResponseDTO=getEmployeeById(employeeFromDB.getId());	
		return employeeResponseDTO;
				
	}
	
	
	public String deleteEmployee(Integer employeeId) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
		Employee employee=optionalEmployee.get();
		employeeRepository.delete(employee);
		return "Employee Deleted Successfully";
	}
	
	public List<EmployeeDTO> getEmployeeByFirstAndLastName(String firstName,String lastName)
	{
		List<EmployeeDTO> employeeDTOs = new ArrayList<>();
		 List<Employee> employees = employeeRepository.findByFirstNameAndLastName(firstName,lastName);
		 Iterator<Employee> itr = employees.iterator();
		 while(itr.hasNext()) {
			 Employee employee = itr.next();
			 EmployeeDTO employeeResponseDTO=new EmployeeDTO();
			 employeeResponseDTO.setId(employee.getId());
			 employeeResponseDTO.setFirstName(employee.getFirstName());
			 employeeResponseDTO.setLastName(employee.getLastName());
			 employeeResponseDTO.setSalary(employee.getSalary());
			 AddressDTO addressDTO = addressServices.getAddressById(employee.getAddress().getId());
			 employeeResponseDTO.setAddress(addressDTO);
			 DepartmentDTO departmentDTO = departmentServices.getDepartmentById(employee.getDepartment().getId());
			 employeeResponseDTO.setDepartment(departmentDTO);
			 employeeDTOs.add(employeeResponseDTO);
		 }
		 return employeeDTOs;
	}
	
	public List<EmployeeDTO> getAllEmployees(){
		List<EmployeeDTO> employeeDTOs = new ArrayList<>();
		List<Employee> employees = employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
		Iterator<Employee> itr = employees.iterator();
		 while(itr.hasNext()) {
			 Employee employee = itr.next();
			 EmployeeDTO employeeResponseDTO=new EmployeeDTO();
			 employeeResponseDTO.setId(employee.getId());
			 employeeResponseDTO.setFirstName(employee.getFirstName());
			 employeeResponseDTO.setLastName(employee.getLastName());
			 employeeResponseDTO.setSalary(employee.getSalary());
			 		 
			 AddressDTO addressDTO =new AddressDTO();
			 addressDTO = addressServices.getAddressById(employee.getAddress().getId());
			 employeeResponseDTO.setAddress(addressDTO);
			 
			 DepartmentDTO departmentDTO = new DepartmentDTO();
			 departmentDTO=departmentServices.getDepartmentById(employee.getDepartment().getId());
			 employeeResponseDTO.setDepartment(departmentDTO);
			 
			 employeeDTOs.add(employeeResponseDTO);
			 
		 }
		 return employeeDTOs;
	}
	
	
	
}
