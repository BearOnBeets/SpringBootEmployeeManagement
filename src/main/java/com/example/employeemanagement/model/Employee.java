package com.example.employeemanagement.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity 
@Table(name = "employee")
public class Employee {
	
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name = "id")
  private Integer id;

  @Column(name = "firstName")
  private String firstName;

  @Column(name = "lastName")
  private String lastName;
  
  @Column(name = "salary")
  private Integer salary;
  
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "addressId", referencedColumnName = "id")
  private Address address;
  
  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "departmentId",referencedColumnName = "id")
  private Department department;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public Integer getSalary() {
	return salary;
}

public void setSalary(Integer salary) {
	this.salary = salary;
}

public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}


public Department getDepartment() {
	return department;
}

public void setDepartment(Department department) {
	this.department = department;
}

@Override
public String toString() {
	return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", Salary=" + salary
			+ ", Address=" + address + ", Department=" + department + "]";
}






}