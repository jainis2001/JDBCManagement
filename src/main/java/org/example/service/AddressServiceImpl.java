package org.example.service;

import org.example.dto.AddressDTO;
import org.example.entity.Address;
import org.example.repo.AddressRepo;
import org.example.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressRepo addressRepo;
	@Autowired
	private Util util;
	@Override
	public Address insertAddress(AddressDTO addressDTO) {
		Address address=util.mapToAddressEntity(addressDTO);
		Address existAddress=addressRepo.findByLandmarkAndPincode(address.getLandmark(),address.getPincode());
		return (existAddress==null)?addressRepo.save(address):existAddress;
	}
}
