package com.example.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeemanagement.model.Role;


public interface RoleRepository extends JpaRepository<Role, Integer>{

}
