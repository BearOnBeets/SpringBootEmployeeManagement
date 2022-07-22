package com.example.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employeemanagement.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
