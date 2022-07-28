package com.example.employeemanagement.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employeemanagement.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> 
{
	List<Employee> findByFirstNameOrLastNameContaining(String firstName, String lastName);
}
