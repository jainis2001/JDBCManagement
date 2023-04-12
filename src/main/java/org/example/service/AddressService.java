package org.example.service;


import org.example.dto.AddressDTO;
import org.example.entity.Address;
import org.springframework.stereotype.Service;

public interface AddressService {
	Address insertAddress(AddressDTO addressDTO);


}
