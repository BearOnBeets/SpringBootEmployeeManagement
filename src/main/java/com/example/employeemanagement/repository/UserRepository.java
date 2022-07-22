package com.example.employeemanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeemanagement.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserNameAndPassword(String userName, String password);
	User findByUserName(String username);
}
