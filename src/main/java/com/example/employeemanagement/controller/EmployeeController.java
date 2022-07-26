package com.example.employeemanagement.controller;
import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.services.EmployeeServices;
import com.example.employeemanagement.services.IEmployeeServices;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping(path="employees") 
public class EmployeeController {
  
  @Autowired
  private IEmployeeServices employeeServices;
  
  @PostMapping()
  public @ResponseBody ResponseEntity<EmployeeDTO> createNewEmployee (@RequestBody EmployeeDTO employeeDTO) {
	  
	  EmployeeDTO employee=employeeServices.saveEmployee(employeeDTO);
	  return new ResponseEntity<>(employee, HttpStatus.OK);
	  
  }
  
  @PutMapping(value="/{employeeId}")
  
  public @ResponseBody ResponseEntity<EmployeeDTO> updateEmployee (@PathVariable(name = "employeeId")Integer employeeId,@RequestBody EmployeeDTO employeeDTO) {	  
	  EmployeeDTO employee=employeeServices.updateEmployee(employeeId,employeeDTO);
	  return new ResponseEntity<>(employee, HttpStatus.OK);
  }

  
  @DeleteMapping(value="/{employeeId}")
  public @ResponseBody ResponseEntity<String> deleteEmployee (@PathVariable(name = "employeeId")Integer employeeId) {
	  String response=employeeServices.deleteEmployee(employeeId);
	  return new ResponseEntity<>(response, HttpStatus.OK);

  }
  
  @GetMapping(path="/search")
  public @ResponseBody ResponseEntity<List<EmployeeDTO>> searchEmployee (@RequestParam String firstName,@RequestParam String lastName) {
	 List<EmployeeDTO> employee=employeeServices.getEmployeeByFirstAndLastName(firstName, lastName);
	  return new ResponseEntity<>(employee, HttpStatus.OK);
  }
   
  @GetMapping()
  public @ResponseBody ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
    List<EmployeeDTO> employees=employeeServices.getAllEmployees();
    
    return new ResponseEntity<>(employees, HttpStatus.OK);
  }
  
  @PreAuthorize("hasAuthority('admin')")
  @PostMapping(path="update-multiple-employees")
  public @ResponseBody ResponseEntity<List<EmployeeDTO>> updateMultipleEmployees (@RequestBody List<EmployeeDTO> employeeDTOs){
	  List<EmployeeDTO> employees=employeeServices.updateMultipleEmployee(employeeDTOs);
	  return new ResponseEntity<>(employees, HttpStatus.OK);  
	} 
}