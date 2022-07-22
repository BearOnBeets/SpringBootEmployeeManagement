package com.example.employeemanagement.dto;

public class EmployeeDTO {

	private Integer id;
	private String firstName;
	private String lastName;
	private Integer salary;
	private AddressDTO address;
	private DepartmentDTO department;

	
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
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	public DepartmentDTO getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentDTO department) {
		this.department = department;
	}
	public EmployeeDTO(Integer id, String firstName, String lastName, Integer salary, AddressDTO address,
			DepartmentDTO department,Integer departmentId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.address = address;
		this.department = department;
	}
	public EmployeeDTO() {
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ ", address=" + address + ", department=" + department + "]";
	}
	  
}
