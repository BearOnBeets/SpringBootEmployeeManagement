package com.example.employeemanagement.services;

import com.example.employeemanagement.dto.AddressDTO;

public interface IAddressServices {

	public AddressDTO getAddressById(Integer addressId);
	public AddressDTO saveAddress(AddressDTO addressDTO);
	public AddressDTO updateAddress(Integer addressId,AddressDTO addressDTO); 
}
