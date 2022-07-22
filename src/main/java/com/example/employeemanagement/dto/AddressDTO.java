package com.example.employeemanagement.dto;

public class AddressDTO {
	private Integer id;

	private String buildingName;

	private String street;
	
	private String city;
	  
	private Integer zipcode;
	

	public AddressDTO() {
	
		// TODO Auto-generated constructor stub
	}

	public AddressDTO(Integer id, String buildingName, String street, String city, Integer zipcode, EmployeeDTO employee) {
		super();
		this.id = id;
		this.buildingName = buildingName;
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
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

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}


	@Override
	public String toString() {
		return "AddressDTO [id=" + id + ", buildingName=" + buildingName + ", street=" + street + ", city=" + city
				+ ", zipcode=" + zipcode + "]";
	}
    
}
