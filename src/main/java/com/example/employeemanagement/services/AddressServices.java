package com.example.employeemanagement.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemanagement.dto.AddressDTO;
import com.example.employeemanagement.model.*;
import com.example.employeemanagement.repository.AddressRepository;

@Service
public class AddressServices implements IAddressServices{
	
	@Autowired
	private AddressRepository addressRepository;
		
	public AddressDTO getAddressById(Integer addressId) {
		Optional<Address> optionalAddress = addressRepository.findById(addressId);
		Address address=optionalAddress.get();
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setId(address.getId());
		addressDTO.setBuildingName(address.getBuildingName());
		addressDTO.setCity(address.getCity());
		addressDTO.setStreet(address.getStreet());
		addressDTO.setZipcode(address.getZipcode());
		return addressDTO;
	}

	public AddressDTO saveAddress(AddressDTO addressDTO) {
		Address address=new Address();
	    address.setBuildingName(addressDTO.getBuildingName());
	    address.setCity(addressDTO.getCity());
	    address.setStreet(addressDTO.getStreet());
	    address.setZipcode(addressDTO.getZipcode());
	    Address addressFromDB = addressRepository.save(address);
	    
	    AddressDTO addressResponseDTO = new AddressDTO();
	    addressResponseDTO.setId(addressFromDB.getId());
		addressResponseDTO.setBuildingName(addressFromDB.getBuildingName());
		addressResponseDTO.setCity(addressFromDB.getCity());
		addressResponseDTO.setStreet(addressFromDB.getStreet());
		addressResponseDTO.setZipcode(addressFromDB.getZipcode());
	

		return addressResponseDTO;
	}
	
	public AddressDTO updateAddress(Integer addressId,AddressDTO addressDTO) {
		Optional<Address> optionalAddress = addressRepository.findById(addressId);
		Address address=optionalAddress.get();
	    address.setBuildingName(addressDTO.getBuildingName());
	    address.setCity(addressDTO.getCity());
	    address.setStreet(addressDTO.getStreet());
	    address.setZipcode(addressDTO.getZipcode());
	    Address addressFromDB = addressRepository.save(address);
	    
	    AddressDTO addressResponseDTO = new AddressDTO();
	    addressResponseDTO.setId(addressFromDB.getId());
		addressResponseDTO.setBuildingName(addressFromDB.getBuildingName());
		addressResponseDTO.setCity(addressFromDB.getCity());
		addressResponseDTO.setStreet(addressFromDB.getStreet());
		addressResponseDTO.setZipcode(addressFromDB.getZipcode());
		return addressResponseDTO;
	    
	}
	
}
