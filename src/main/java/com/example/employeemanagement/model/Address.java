package com.example.employeemanagement.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity 
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "buildingName")
	private String buildingName;

	@Column(name = "street")
	private String street;
	
	@Column(name = "city")
	private String city;
	  
	@Column(name = "zipcode")
	private Integer zipcode;
	
	@OneToOne(mappedBy = "address",cascade=CascadeType.ALL)
    private Employee employee;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingNumber) {
		this.buildingName = buildingNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getZipcode() {
		return zipcode;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}


	@Override
	public String toString() {
		return "Address [id=" + id + ", buildingName=" + buildingName + ", street=" + street + ", city=" + city
				+ ", zipcode=" + zipcode + ", Employee=" + employee + "]";
	}






	
}
